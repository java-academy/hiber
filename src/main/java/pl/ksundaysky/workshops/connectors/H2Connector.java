package pl.ksundaysky.workshops.connectors;

import org.hibernate.cfg.Environment;

import java.util.Properties;

/**
 * @author krzysztof.niedzielski
 */
public class H2Connector extends SessionConnector {
    @Override
    Properties loadConnectorSettings() {
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "org.h2.Driver");
        settings.put(Environment.URL, "jdbc:h2:tcp://localhost/~/test");
        settings.put(Environment.USER, "sa");
        settings.put(Environment.PASS, "sa");
        settings.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
        settings.put(Environment.SHOW_SQL, "true");
        settings.put(Environment.HBM2DDL_AUTO, "create-drop");
        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        return settings;
    }
}
