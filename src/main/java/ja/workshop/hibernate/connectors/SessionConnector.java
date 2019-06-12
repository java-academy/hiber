package ja.workshop.hibernate.connectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

/**
 * Creates connections between Java and specific database.
 *
 * @author Kamil Rojek
 */
public abstract class SessionConnector implements ISession {
    private SessionFactory sessionFactory;

    /**
     * Opens session from SessionFactory.
     *
     * @return Session object.
     */
    @Override
    public Session getSession() {
        return this.getSessionFactory().openSession();
    }

    private SessionFactory getSessionFactory() {
        if (sessionFactory != null)
            return sessionFactory;
        Configuration configuration = createConfiguration();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        return sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    private Configuration createConfiguration() {
        Properties settings = loadConnectorSettings();
        Configuration configuration = new Configuration();
        configuration.setProperties(settings);
        addEntities(configuration);
        return configuration;
    }

    /**
     * Adds entities to project configuration.
     *
     * @param configuration
     */
    private void addEntities(Configuration configuration) {
        configuration.addAnnotatedClass(YOUR CLASSES);
    }

    abstract Properties loadConnectorSettings();
}
