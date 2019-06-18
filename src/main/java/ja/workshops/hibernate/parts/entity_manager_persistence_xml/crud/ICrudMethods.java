package ja.workshops.hibernate.parts.entity_manager_persistence_xml.crud;

import org.hibernate.Session;

import java.io.Serializable;

/**
 * @author Kamil Rojek
 */
public interface ICrudMethods {
    void initializeSession(Session session);
    /**
     * Creates new record in database.
     *
     * @param record - record to create
     * @param <R>    - type of record
     */
    <R> void create(R record);

    /**
     * Reads object from database.
     *
     * @param clazz - class that is mapped on record we want to read
     * @param id    - index of record
     * @param <T>   - type of index
     * @return - record as an object
     */
    <T extends Serializable> Object read(Class<?> clazz, T Id);

    /**
     * Updates specific record in database.
     *
     * @param record - record to update
     * @param <R>    - type of record
     */
    <R> void update(R record);

    /**
     * Deletes specific record from database.
     *
     * @param record - record to delete
     * @param <R>    - type of record
     */
    <R> void delete(R record);
}