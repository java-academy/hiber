package ja.workshop.hibernate.connectors;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.service.spi.ServiceException;
import ja.workshop.hibernate.crud.CrudHandler;
import ja.workshop.hibernate.crud.CrudMethods;
import ja.workshop.hibernate.crud.ICrudMethods;

import java.util.List;

/**
 * @author Kamil Rojek
 * @author Agnieszka Trzewik
 */
public class ConnectorManager<T extends ISession> implements AutoCloseable {
    private T connector;
    private Transaction transaction;
    private static Session session;
    private ICrudMethods crudMethods;

    private ConnectorManager(T connector) {
        this.connector = connector;
        this.crudMethods = new CrudMethods();
    }

    public static <T extends ISession> ConnectorManager connect(T connector) {
        return new ConnectorManager<>(connector);
    }

    public CrudHandler openCrudSession(ICrudMethods crudMethods) {
        this.crudMethods = crudMethods;
        return CrudHandler.initiliazieCrudHandler(crudMethods, this);
    }

    public void commitAndClose() throws SessionInitializationException {
        initializeSession();
        transaction.commit();
        close();
    }

    public void commitAndClose(List<?> recordsToCreate, List<?> recordsToUpdate) throws SessionInitializationException {
        initializeSession();
        recordsToCreate.forEach(crudMethods::create);
        recordsToUpdate.forEach(crudMethods::update);
        transaction.commit();
        close();
    }

    private void initializeSession() throws SessionInitializationException {
        try {
            session = (session == null || !session.isConnected())  ? connector.getSession() : session;
            transaction = (transaction == null || !transaction.isActive()) ? session.beginTransaction() : transaction;
            crudMethods.initializeSession(session);
        } catch (ServiceException e) {
            throw new SessionInitializationException("Session initialization failed!");
        }
    }

    public Session getSession() throws SessionInitializationException {
        initializeSession();
        return session;
    }

    @Override
    public void close() {
        session.close();
    }
}
