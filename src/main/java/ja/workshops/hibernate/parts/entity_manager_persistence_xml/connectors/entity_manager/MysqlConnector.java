package ja.workshops.hibernate.parts.entity_manager_persistence_xml.connectors.entity_manager;

/**
 * @author krzysztof.niedzielski
 */
public class MysqlConnector extends EntityManagerConnector {

    @Override
    void setPersistenceUnitName() {
        persistenceUnitName = PersistenceUnitName.MySQL.getPersistenceUnitName();
    }


}
