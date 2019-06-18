package ja.workshops.hibernate.parts.xml_configuration;

import ja.workshops.hibernate.parts.xml_configuration.connectors.Connector;
import org.hibernate.Session;

/**
 * @author Ola Podorska
 */
class App {

    public static void main(String[] args) {
        Session session = Connector.getSession();
        session.beginTransaction();
    }
}
