package ja.workshops.hibernate.parts.entity_manager_persistence_xml.connectors.entity_manager;


/**
 * @author krzysztof.niedzielski
 */
public class H2Connector extends EntityManagerConnector {

    @Override
    void setPersistenceUnitName() {
        persistenceUnitName = PersistenceUnitName.H2.getPersistenceUnitName();
    }
}
