package ja.workshop.hibernate.connectors;

import ja.workshop.hibernate.model.Author;
import ja.workshop.hibernate.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

/**
 * @author krzysztof.niedzielski
 */
public class H2Connector implements Connector {
    private static SessionFactory sessionFactory;


    private  SessionFactory getSessionFactory() {
        if(sessionFactory==null) {

                Configuration configuration = new Configuration();
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "org.h2.Driver");
                settings.put(Environment.URL, "jdbc:h2:tcp://localhost/~/test");
                settings.put(Environment.USER, "sa");
                settings.put(Environment.PASS, "");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
                settings.put(Environment.HBM2DDL_AUTO, "create-drop");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                configuration.setProperties(settings);
                configuration.addAnnotatedClass(Book.class);
                configuration.addAnnotatedClass(Author.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        }
        return sessionFactory;
    }
    @Override
    public Session getSession() {
        return this.getSessionFactory().openSession();
    }
}
