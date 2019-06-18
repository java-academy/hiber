package ja.workshops.hibernate.parts.entity_manager_persistence_xml.connectors.entity_manager;


import ja.workshops.hibernate.parts.entity_manager_persistence_xml.connectors.ISession;
import ja.workshops.hibernate.parts.entity_manager_persistence_xml.connectors.SessionCloseException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Interface with methods for opening and closing connection to database.
 *
 * @author krzysztof.kramarz
 */
public interface IEntityManagerConnector extends ISession {
    /**
     * Creates {@link EntityManager}
     *
     * @return EntityManager
     */
    EntityManager createEntityManager();


    /**
     * Closes opened {@link EntityManagerFactory}
     *
     * @throws SessionCloseException
     */
    void closeEntityManagerFactory() throws SessionCloseException;

}
