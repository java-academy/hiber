package ja.workshops.hibernate.parts.connectors;

import org.hibernate.cfg.Environment;

import java.util.Properties;

/**
 * @author krzysztof.niedzielski
 */
public class MysqlConnector extends SessionConnector {
    @Override
    Properties loadConnectorSettings() {
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        settings.put(Environment.URL, "jdbc:mysql://localhost:3306/{database}?serverTimezone=UTC");
        settings.put(Environment.USER, "{username}");
        settings.put(Environment.PASS, "{password}");
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
        settings.put(Environment.SHOW_SQL, "true");
        settings.put(Environment.HBM2DDL_AUTO, "create-drop");
        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        return settings;
    }
}
