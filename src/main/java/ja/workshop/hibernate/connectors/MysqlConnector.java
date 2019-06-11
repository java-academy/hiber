package ja.workshop.hibernate.connectors;

import org.hibernate.cfg.Environment;

import java.util.Properties;

/**
 * @author krzysztof.niedzielski
 */
public class MysqlConnector extends Connector {

    //TODO: Change {database},{username} and {password} to your credentials!
    // Run main method
    // If everything works, tables should be in db.

    @Override
    Properties loadConnectorSettings() {
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        settings.put(Environment.URL, "jdbc:mysql://localhost:3306/{database}?serverTimezone=UTC");
        settings.put(Environment.USER, "{username}");
        settings.put(Environment.PASS, "{password}");
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
        settings.put(Environment.HBM2DDL_AUTO, "create-drop");
        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        return settings;
    }
}
