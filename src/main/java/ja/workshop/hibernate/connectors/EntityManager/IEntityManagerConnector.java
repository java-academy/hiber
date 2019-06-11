package ja.workshop.hibernate.connectors.EntityManager;

import ja.workshop.hibernate.connectors.ISession;

import javax.persistence.EntityManager;

/**
 * @author krzysztof.kramarz
 */
public interface IEntityManagerConnector extends ISession {
    EntityManager getEntityManager();

    void closeEntitymanagerFactory() throws IllegalStateException;

}
