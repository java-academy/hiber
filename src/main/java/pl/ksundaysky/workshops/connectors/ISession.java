package pl.ksundaysky.workshops.connectors;

import org.hibernate.Session;

/**
 * @author Kamil Rojek
 */
public interface ISession {
    Session getSession();
}
