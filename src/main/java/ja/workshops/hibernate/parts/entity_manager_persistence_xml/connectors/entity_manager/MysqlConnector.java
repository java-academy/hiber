package ja.workshops.hibernate.parts.entity_manager_persistence_xml.connectors.entity_manager;

/**
 * Connector to MySQL database.
 *
 * @author Krzysztof Kramarz
 */
public class MysqlConnector extends EntityManagerConnector {

    @Override
    void setPersistenceUnitName() {
        persistenceUnitName = PersistenceUnitName.MySQL.getPersistenceUnitName();
    }


}
