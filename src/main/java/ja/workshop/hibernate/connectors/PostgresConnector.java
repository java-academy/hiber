package ja.workshop.hibernate.connectors;

import org.hibernate.cfg.Environment;

import java.util.Properties;

/**
 * @author krzysztof.niedzielski
 */
public class PostgresConnector extends Connector {

    @Override
    Properties loadConnectorSettings() {
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "org.postgresql.Driver");
        settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/mojaBaza");
        settings.put(Environment.USER, "postgres");
        settings.put(Environment.PASS, "postgres");
        settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL10Dialect");
        settings.put(Environment.HBM2DDL_AUTO, "create");
        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        settings.put(Environment.SHOW_SQL, "true");
        return settings;
    }
}
