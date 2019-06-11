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
public class MysqlConnector implements Connector {

    private static SessionFactory sessionFactory;

    public  SessionFactory getSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            Properties settings = new Properties();
            settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
            settings.put(Environment.URL, "jdbc:mysql://localhost:3306/db1?serverTimezone=UTC");
            settings.put(Environment.USER, "username");
            settings.put(Environment.PASS, "password");
            settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
            settings.put(Environment.HBM2DDL_AUTO, "create-drop");
            settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
            configuration.setProperties(settings);
            configuration.addAnnotatedClass(Book.class);
            configuration.addAnnotatedClass(Author.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sessionFactory;
    }


    @Override
    public Session getSession() {
        return this.getSessionFactory().getCurrentSession();
    }
}
