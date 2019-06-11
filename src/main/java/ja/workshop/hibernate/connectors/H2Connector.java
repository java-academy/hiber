package ja.workshop.hibernate.connectors;

import org.hibernate.cfg.Environment;

import java.util.Properties;

/**
 * @author krzysztof.niedzielski
 */
public class H2Connector extends Connector {
    
    //TODO: Change {database},{username} and {password} to your credentials!
    // Run main method
    // If everything works, tables should be in db.

    @Override
    Properties loadConnectorSettings() {
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "org.h2.Driver");//Driver to db
        settings.put(Environment.URL, "jdbc:h2:tcp://localhost/~/{database}"); //Db server url
        settings.put(Environment.USER, "{username}"); // Your username
        settings.put(Environment.PASS, "{password}"); // your password
        settings.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect"); // SQL Dialect
        settings.put(Environment.HBM2DDL_AUTO, "create-drop"); // what happens when SessionFactory is created
        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread"); // Bind Session to thread where SessionFactory.openSession() was called
        return settings;
    }
}
