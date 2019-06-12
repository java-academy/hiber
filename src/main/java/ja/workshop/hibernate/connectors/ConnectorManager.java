package ja.workshop.hibernate.connectors;

import ja.workshop.hibernate.crud.CrudHandler;
import ja.workshop.hibernate.crud.ICrudMethods;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.service.spi.ServiceException;

import java.util.List;

/**
 * Manages connection and operations between Java and Database.
 *
 * @author Kamil Rojek
 * @author Agnieszka Trzewik
 */
public class ConnectorManager<T extends ISession> implements AutoCloseable {
    private T connector;
    private Transaction transaction;
    private Session session;
    private ICrudMethods crudMethods;

    private ConnectorManager(T connector) {
        this.connector = connector;
    }

    /**
     * Handles specific connection to database.
     *
     * @param connector - database connector such a H2, MySql etc.
     * @param <T>       - type of connector
     * @return - initialized ConnectorManager class
     */
    public static <T extends ISession> ConnectorManager<T> connect(T connector) {
        return new ConnectorManager<>(connector);
    }

    /**
     * Opens CRUD session that allows operate on specific database
     * using Create, Read, Update, Delete methods.
     *
     * @param crudMethods - crud methods implementation
     * @return - CrudHandler
     */
    public CrudHandler openCrudSession(ICrudMethods crudMethods) {
        this.crudMethods = crudMethods;
        return CrudHandler.initiliazieCrudHandler(crudMethods, this);
    }

    /**
     * Commits objects into database and closes session.
     *
     * @throws SessionInitializationException - thrown when error occurs
     *                                        during session initialization.
     */
    public void commitAndClose() throws SessionInitializationException {
        initializeSession();
        transaction.commit();
        close();
    }

    /**
     * Commits objects into database and closes session.
     *
     * @param recordsToCreate - list of records to add to database
     * @param recordsToUpdate - list of records to update in database
     * @throws SessionInitializationException - thrown when error occurs
     *                                        during session initialization.
     */
    public void commitAndClose(List<?> recordsToCreate, List<?> recordsToUpdate) throws SessionInitializationException {
        initializeSession();
        recordsToCreate.forEach(crudMethods::create);
        recordsToUpdate.forEach(crudMethods::update);
        transaction.commit();
        close();
    }

    /**
     * Initializes session.
     *
     * @throws SessionInitializationException - thrown when error occurs
     *                                        during session initialization.
     */
    public void initializeSession() throws SessionInitializationException {
        try {
            session = (session == null) ? connector.getSession() : session;
            transaction = (transaction == null || !transaction.isActive()) ? session.beginTransaction() : transaction;
            crudMethods.initializeSession(session);
        } catch (ServiceException e) {
            throw new SessionInitializationException("Session initialization failed!");
        }
    }

    /**
     * Returns initialized session.
     *
     * @return session object
     * @throws SessionInitializationException - thrown when error occurs
     *                                        during session initialization.
     */
    public Session getSession() throws SessionInitializationException {
        initializeSession();
        return session;
    }

    /**
     * Closes session.
     */
    @Override
    public void close() {
        session.close();
    }
}
