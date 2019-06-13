package ja.workshops.hibernate.parts.entity_manager_persistence_xml.connectors.entity_manager;


import ja.workshops.hibernate.parts.entity_manager_persistence_xml.connectors.ISession;

import javax.persistence.EntityManager;

/**
 * @author krzysztof.kramarz
 */
public interface IEntityManagerConnector extends ISession {
    EntityManager getEntityManager();

    void closeEntitymanagerFactory() throws IllegalStateException;

}
