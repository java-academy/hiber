package ja.workshops.hibernate.parts.entity_manager_persistence_xml.crud;


import ja.workshops.hibernate.parts.entity_manager_persistence_xml.connectors.SessionInitializationException;
import ja.workshops.hibernate.parts.entity_manager_persistence_xml.connectors.session.SessionConnectorManager;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * Handles CRUD methods with automatic session initialization,
 * transaction opening, entities committing and session closing.
 * <p>
 * It provides lazily persisting/saving collections of entities
 * (collecting entities in {@code List<Object> recordsToAdd}
 * and {@code List<Object> recordsToUpdate}).
 *
 * @author Kamil Rojek
 */
public class CrudHandler {
    private ICrudMethods crudMethods;
    private SessionConnectorManager<?> sessionConnectorManager;
    private List<Object> recordsToAdd;
    private List<Object> recordsToUpdate;

    private CrudHandler(ICrudMethods crudMethods, SessionConnectorManager<?> sessionConnectorManager) {
        this.crudMethods = crudMethods;
        this.sessionConnectorManager = sessionConnectorManager;

        recordsToAdd = new ArrayList<>();
        recordsToUpdate = new ArrayList<>();
    }

    /**
     * Initializes new CrudHandler class.
     *
     * @param crudMethods             - API of basic crud methods (create, read, update, delete).
     * @param sessionConnectorManager - manager of connection between java and database
     * @return CrudHandler
     */
    public static CrudHandler initializeCrudHandler(ICrudMethods crudMethods, SessionConnectorManager<?> sessionConnectorManager) {
        return new CrudHandler(crudMethods, sessionConnectorManager);
    }

    /**
     * Adding records to {@code List<Object> recordsToAdd}
     *
     * @param records - collection of records
     * @return CrudHandler
     */
    public CrudHandler addRecord(Collection<?> records) {
        for (Object r : records) {
            addRecord(r);
        }
        return this;
    }

    /**
     * Adds record to {@code List<Object> recordsToAdd}
     *
     * @param record - single record
     * @param <R>    - record type
     * @return - CrudHandler
     */
    public <R> CrudHandler addRecord(R record) {
        recordsToAdd.add(record);
        return this;
    }

    /**
     * Adds records to {@code List<Object> recordsToUpdate}
     *
     * @param records - collection of records
     * @return CrudHandler
     */
    public CrudHandler updateRecord(Collection<?> records) {
        for (Object r : records) {
            updateRecord(r);
        }
        return this;
    }

    /**
     * Adds record to {@code List<Object> recordsToUpdate}
     *
     * @param record - single record
     * @param <R>    - record type
     * @return - CrudHandler
     */
    public <R> CrudHandler updateRecord(R record) {
        recordsToUpdate.add(record);
        return this;
    }

    /**
     * Reads record from data base.
     *
     * @param clazz - class represents record in database
     * @param id    - id of record
     * @param <T>   - type of identity
     * @return - record as an object
     */
    public <T extends Serializable> Object readRecord(Class<?> clazz, T id) {
        try (Session session = sessionConnectorManager.getSession()) {
            crudMethods.initializeSession(session);
            return crudMethods.read(clazz, id);
        } catch (SessionInitializationException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Deletes record from database.
     *
     * @param record - record to delete
     * @param <R>    - type of record
     */
    public <R> void deleteRecord(R record) {
        try (Session session = sessionConnectorManager.getSession()) {
            crudMethods.initializeSession(session);
            crudMethods.delete(record);
            sessionConnectorManager.commitAndClose();
        } catch (SessionInitializationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Commits and close session.
     */
    public void commitAndClose() {
        try {
            sessionConnectorManager.commitAndClose(recordsToAdd, recordsToUpdate);
        } catch (SessionInitializationException e) {
            e.printStackTrace();
        }
    }
}