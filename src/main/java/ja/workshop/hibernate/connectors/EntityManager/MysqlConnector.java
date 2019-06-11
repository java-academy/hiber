package ja.workshop.hibernate.connectors.EntityManager;

/**
 * @author krzysztof.niedzielski
 */
public class MysqlConnector extends EntityManagerConnector {

    @Override
    void setPersistenceUnitName() {
        persistenceUnitName = PersistenceUnitName.MySQL.getPersistenceUnitName();
    }


}
