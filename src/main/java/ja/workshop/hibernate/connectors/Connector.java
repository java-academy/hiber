package ja.workshop.hibernate.connectors;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

/**
 * @author Kamil Rojek
 */
public abstract class Connector {

    public static Session getSession() {
        return new Configuration().configure().buildSessionFactory().getCurrentSession();
    }

}
