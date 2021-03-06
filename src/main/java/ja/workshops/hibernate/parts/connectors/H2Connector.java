package ja.workshops.hibernate.parts.connectors;

import org.hibernate.cfg.Environment;

import java.util.Properties;

/**
 * Basic settings to connect with H2 database.
 * Need to change URL, USER and PASS properties.
 *
 * @author krzysztof.niedzielski
 */
public class H2Connector extends SessionConnector {

    private String ddlAuto;

    public H2Connector(String ddlAuto) {
        this.ddlAuto = ddlAuto;
    }

    public H2Connector() {
        ddlAuto="create-drop";
    }

    @Override
    Properties loadConnectorSettings() {
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "org.h2.Driver");
        settings.put(Environment.URL, "jdbc:h2:tcp://localhost/~/{database}");
        settings.put(Environment.USER, "{username}");
        settings.put(Environment.PASS, "{password}");
        settings.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
        settings.put(Environment.SHOW_SQL, "true");
        settings.put(Environment.HBM2DDL_AUTO, ddlAuto);
        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        return settings;
    }
}
