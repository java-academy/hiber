package ja.workshop.hibernate.crud;

import org.hibernate.MappingException;
import org.hibernate.Session;

import java.io.Serializable;

/**
 * @author Kamil Rojek
 */
public class CrudMethods implements ICrudMethods {
    private Session session;

    public Session getSession() {
        return session;
    }

    @Override
    public void initializeSession(Session session) {
        this.session = session;
    }

    @Override
    public <R> void create(R record) {
        try {
            session.persist(record);
        } catch (MappingException e) {
            System.err.println("Adding record failed -> " + record.toString());
        }
    }

    @Override
    public <T extends Serializable> Object read(Class c, T id) {
        return session.get(c, id);
    }

    @Override
    public <R> void update(R record) {
        try {
            session.saveOrUpdate(record);
        } catch (MappingException e) {
            System.err.println("Updating record failed -> " + record.toString());
        }
    }

    @Override
    public <R> void delete(R record) {
        session.delete(record);
    }
}
