package ja.workshops.hibernate.parts.entity_manager_persistence_xml.connectors.entity_manager;

/**
 * @author krzysztof.kramarz
 */
public enum PersistenceUnitName {
    MySQL("myEntityManagerMySQL"),
    PostgreSQL("myEntityManagerPostgreSQL"),
    H2("myEntityManagerH2");

    private String persistenceUnitName;

    PersistenceUnitName(String persistenceUnitName) {
        this.persistenceUnitName = persistenceUnitName;
    }

    public String getPersistenceUnitName() {
        return persistenceUnitName;
    }

}
