package ja.workshop.hibernate;

import ja.workshop.hibernate.connectors.H2Connector;
import ja.workshop.hibernate.connectors.MysqlConnector;
import ja.workshop.hibernate.connectors.PostgresConnector;

/**
 * @author krzysztof.niedzielski
 */
public class App {
    public static void main(String[] args) {
        new H2Connector().getSession();
        new MysqlConnector().getSession();
        new PostgresConnector().getSession();
    }

}
