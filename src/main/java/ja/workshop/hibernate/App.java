package ja.workshop.hibernate;

import ja.workshop.hibernate.connectors.Connector;
import org.hibernate.Session;

/**
 * @author Ola Podorska
 */
public class App {
    private static Session session = Connector.getSession();

    public static void main(String[] args) {
        session.beginTransaction();
    }

}
