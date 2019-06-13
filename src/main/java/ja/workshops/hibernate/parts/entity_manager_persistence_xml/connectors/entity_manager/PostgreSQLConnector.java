package ja.workshops.hibernate.parts.entity_manager_persistence_xml.connectors.entity_manager;

/**
 * @author krzysztof.niedzielski
 */
public class PostgreSQLConnector extends EntityManagerConnector {

    @Override
    void setPersistenceUnitName() {
        persistenceUnitName = PersistenceUnitName.PostgreSQL.getPersistenceUnitName();
    }
}
