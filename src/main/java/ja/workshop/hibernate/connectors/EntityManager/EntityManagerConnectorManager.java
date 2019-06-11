package ja.workshop.hibernate.connectors.EntityManager;

import ja.workshop.hibernate.connectors.ConnectorManager;
import ja.workshop.hibernate.connectors.SessionCloseException;
import ja.workshop.hibernate.connectors.SessionInitializationException;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TransactionRequiredException;
import java.util.ArrayList;

/**
 * @author krzysztof.kramarz
 */
public class EntityManagerConnectorManager<T extends IEntityManagerConnector> extends ConnectorManager<T> {

    private final EntityManager entityManager;
    private final EntityTransaction transaction;

    private EntityManagerConnectorManager(T connector) {
        super.connector = connector;
        records = new ArrayList<>();
        entityManager = connector.getEntityManager();
        transaction = entityManager.getTransaction();
    }

    public static <T extends IEntityManagerConnector> ConnectorManager<T> of(T connector) {
        return new EntityManagerConnectorManager<>(connector);
    }

    @Override
    public void commitAndClose() throws SessionInitializationException, SessionCloseException {
        transaction.begin();

        for (Object r : records) {
            try {
                entityManager.persist(r);
            } catch (EntityExistsException | IllegalArgumentException | TransactionRequiredException e) {
                throw new SessionInitializationException(" Adding record failed -> " + r);
            }
        }

        transaction.commit();
        closeSession();
    }


    private void closeSession() throws SessionCloseException {

        try {
            entityManager.close();
            connector.closeEntitymanagerFactory();

        } catch (IllegalStateException e) {
            throw new SessionCloseException("Session close failed!!");
        }

    }
}
