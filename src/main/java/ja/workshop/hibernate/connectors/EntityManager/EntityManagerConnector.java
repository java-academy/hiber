package ja.workshop.hibernate.connectors.EntityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Kamil Rojek
 */
public abstract class EntityManagerConnector implements IEntityManagerConnector {
    private EntityManagerFactory entityManagerFactory;
    protected String persistenceUnitName;

    @Override
    public EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }

    @Override
    public void closeEntitymanagerFactory() throws IllegalStateException {
        entityManagerFactory.close();
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
