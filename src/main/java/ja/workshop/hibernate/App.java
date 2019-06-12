package ja.workshop.hibernate;
import ja.workshop.hibernate.connectors.ConnectorManager;
import ja.workshop.hibernate.connectors.H2Connector;
import ja.workshop.hibernate.connectors.SessionConnector;
import ja.workshop.hibernate.crud.CrudMethods;

/**
 * @author Kamil Rojek
 */
public class App {
    public static void main(String[] args)
    {
        connect(new H2Connector())
                .openCrudSession(new CrudMethods())
                .addRecord(YOUR OBJECTS)
                .commitAndClose();
    }
    private static ConnectorManager connect(SessionConnector connector) {
        return ConnectorManager.connect(connector);
    }
}
