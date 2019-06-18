package ja.workshops.hibernate.parts.configuration;

import ja.workshops.hibernate.parts.connectors.H2Connector;
import ja.workshops.hibernate.parts.connectors.MysqlConnector;
import ja.workshops.hibernate.parts.connectors.PostgresConnector;

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
