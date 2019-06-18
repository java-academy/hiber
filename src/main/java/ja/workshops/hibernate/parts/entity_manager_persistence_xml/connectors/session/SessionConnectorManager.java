package ja.workshops.hibernate.parts.entity_manager_persistence_xml.connectors.session;


import ja.workshops.hibernate.parts.entity_manager_persistence_xml.connectors.ConnectorManager;
import ja.workshops.hibernate.parts.entity_manager_persistence_xml.connectors.SessionInitializationException;
import ja.workshops.hibernate.parts.entity_manager_persistence_xml.crud.CrudHandler;
import ja.workshops.hibernate.parts.entity_manager_persistence_xml.crud.CrudMethods;
import ja.workshops.hibernate.parts.entity_manager_persistence_xml.crud.ICrudMethods;
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
public class SessionConnectorManager<T extends ISessionConnector> extends ConnectorManager<T> implements AutoCloseable {
    private Transaction transaction;
    private Session session;
    private ICrudMethods crudMethods;

    private SessionConnectorManager(T connector) {
        this.connector = connector;
    }

    /**
     * Handles specific connection to database.
     *
     * @param connector - database connector such a H2, MySql etc.
     * @param <T>       - type of connector
     * @return - initialized SessionConnectorManager class
     */
    public static <T extends ISessionConnector> SessionConnectorManager<T> connect(T connector) {
        return new SessionConnectorManager<>(connector);
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
        return CrudHandler.initializeCrudHandler(crudMethods, this);
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
            crudMethods.initializeSession(session);
        } catch (ServiceException e) {
            throw new SessionInitializationException("session initialization failed!");
        }
    }

    public Transaction beginTransaction() {
        transaction = (transaction == null || !transaction.isActive()) ? session.beginTransaction() : transaction;
        return transaction;
    }

    /**
     * Returns initialized session.
     *
     * @return session object
     * @throws SessionInitializationException - thrown when error occurs
     *                                        during session initialization.
     */
    public Session getSession() throws SessionInitializationException {
        crudMethods = new CrudMethods();
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