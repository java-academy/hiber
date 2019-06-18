package ja.workshops.hibernate.parts.entity_manager_persistence_xml.connectors.entity_manager;

import ja.workshops.hibernate.parts.entity_manager_persistence_xml.connectors.SessionCloseException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Utility class for obtaining connection to specific database.
 * Choose appropriate subclass for given database.
 *
 * @author krzysztof.kramarz
 */
public abstract class EntityManagerConnector implements IEntityManagerConnector {
    private EntityManagerFactory entityManagerFactory;
    protected String persistenceUnitName;

    /**
     * Creates {@link EntityManager}
     *
     * @return EntityManager
     */
    @Override
    public EntityManager createEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }

    /**
     * Closes opened {@link EntityManagerFactory}
     *
     * @throws SessionCloseException
     */
    @Override
    public void closeEntityManagerFactory() throws SessionCloseException {
        try {
            entityManagerFactory.close();
        } catch (IllegalStateException e) {
            throw new SessionCloseException("Failed to close connection to database!");
        }
    }

    private EntityManagerFactory getEntityManagerFactory() {

        if (entityManagerFactory != null) {
            return entityManagerFactory;
        }
        setPersistenceUnitName();

        return entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
    }

    abstract void setPersistenceUnitName();
}
