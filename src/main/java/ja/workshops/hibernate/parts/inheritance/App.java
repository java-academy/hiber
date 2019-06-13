package ja.workshops.hibernate.parts.inheritance;

import ja.workshops.hibernate.parts.connectors.ConnectorManager;
import ja.workshops.hibernate.parts.connectors.H2Connector;
import ja.workshops.hibernate.parts.connectors.SessionConnector;
import ja.workshops.hibernate.parts.crud.CrudMethods;

/**
 * @author Kamil Rojek
 */
class App {
    public static void main(String[] args) {
        connect(new H2Connector())
                .openCrudSession(new CrudMethods())
                .addRecord("YOUR OBJECTS")
                .commitAndClose();
    }

    private static ConnectorManager connect(SessionConnector connector) {
        return ConnectorManager.connect(connector);
    }
}
