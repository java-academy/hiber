package ja.workshops.hibernate.parts.entity_manager_persistence_xml.connectors.entity_manager;


/**
 * Connector to H2 database.
 *
 * @author krzysztof.kramarz
 */
public class H2Connector extends EntityManagerConnector {

    @Override
    void setPersistenceUnitName() {
        persistenceUnitName = PersistenceUnitName.H2.getPersistenceUnitName();
    }
}
