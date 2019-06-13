package ja.workshops.hibernate.parts.crud;

import org.hibernate.MappingException;
import org.hibernate.Session;

import java.io.Serializable;

/**
 * Represents basic CRUD methods.
 *
 * @author Kamil Rojek
 */
public class CrudMethods implements CrudMethodsInterface {
    private Session session;

    /**
     * Initializes hibernate session by passing argument.
     *
     * @param session
     */
    @Override
    public void initializeSession(Session session) {
        this.session = session;
    }

    /**
     * Creates new record in database
     * using session.persist method.
     *
     * @param record - record to create
     * @param <R> - type of record
     */
    @Override
    public <R> void create(R record) {
        try {
            session.persist(record);
        } catch (MappingException e) {
            System.err.println("Adding record failed -> " + record);
        }
    }

    /**
     * Reads object from database
     * using session.persist method.
     *
     * @param clazz - class that is mapped on record we want to read
     * @param id - index of record
     * @param <T> - type of index
     * @return - record as an object
     */
    @Override
    public <T extends Serializable> Object read(Class<?> clazz, T id) {
        return session.get(clazz, id);
    }

    /**
     * Updates specific record in database
     * using session.saveOrUpdate method.
     *
     * @param record - record to update
     * @param <R> - type of record
     */
    @Override
    public <R> void update(R record) {
        try {
            session.saveOrUpdate(record);
        } catch (MappingException e) {
            System.err.println("Updating record failed -> " + record);
        }
    }

    /**
     * Deletes specific record from database
     * using session.delete method.
     *
     * @param record - record to delete
     * @param <R> - type of record
     */
    @Override
    public <R> void delete(R record) {
        session.delete(record);
    }
}