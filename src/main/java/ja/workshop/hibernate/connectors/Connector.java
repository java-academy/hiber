package ja.workshop.hibernate.connectors;

import ja.workshop.hibernate.model.Author;
import ja.workshop.hibernate.model.Book;
import ja.workshop.hibernate.model.Bookstore;
import ja.workshop.hibernate.model.BookstoreBook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

/**
 * @author Kamil Rojek
 */
public abstract class Connector implements ISession {
    private static SessionFactory sessionFactory;

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
        return configuration.buildSessionFactory(serviceRegistry);
    }

    private Configuration createConfiguration() {
        Properties settings = loadConnectorSettings();
        Configuration configuration = new Configuration();
        configuration.setProperties(settings);
        addEntities(configuration);
        return configuration;
    }

    private void addEntities(Configuration configuration) {
        configuration.addAnnotatedClass(Book.class);
        configuration.addAnnotatedClass(Author.class);
        configuration.addAnnotatedClass(Bookstore.class);
        configuration.addAnnotatedClass(BookstoreBook.class);
    }

    abstract Properties loadConnectorSettings();
}
