package ja.workshop.hibernate.connectors.EntityManager;

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
