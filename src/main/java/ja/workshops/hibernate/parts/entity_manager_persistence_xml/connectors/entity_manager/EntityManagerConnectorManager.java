package ja.workshops.hibernate.parts.entity_manager_persistence_xml.connectors.entity_manager;


import ja.workshops.hibernate.parts.entity_manager_persistence_xml.connectors.ConnectorManager;
import ja.workshops.hibernate.parts.entity_manager_persistence_xml.connectors.EntityPersistenceException;
import ja.workshops.hibernate.parts.entity_manager_persistence_xml.connectors.SessionCloseException;

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
        super(connector);
        records = new ArrayList<>();
        entityManager = connector.createEntityManager();
        transaction = entityManager.getTransaction();
    }

    /**
     * Static factory. Use this to create instance of this class.
     *
     * @param connector {@link IEntityManagerConnector}
     * @param <T>       extends {@link IEntityManagerConnector}
     * @return {@link EntityManagerConnectorManager}
     */
    public static <T extends IEntityManagerConnector> EntityManagerConnectorManager<T> of(T connector) {
        return new EntityManagerConnectorManager<>(connector);
    }

    @Override
    public void commitAndClose() throws EntityPersistenceException, SessionCloseException {
        transaction.begin();

        for (Object r : records) {
            try {
                entityManager.persist(r);
            } catch (EntityExistsException | IllegalArgumentException | TransactionRequiredException e) {
                throw new EntityPersistenceException(" Adding record failed -> " + r);
            }
        }

        transaction.commit();
        closeSession();
    }

    private void closeSession() throws SessionCloseException {
        entityManager.close();
        connector.closeEntityManagerFactory();
    }
}
