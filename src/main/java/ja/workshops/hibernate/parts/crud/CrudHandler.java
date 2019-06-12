package ja.workshops.hibernate.parts.crud;

import ja.workshops.hibernate.parts.connectors.ConnectorManager;
import ja.workshops.hibernate.parts.connectors.SessionInitializationException;
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
    private ConnectorManager<?> connectorManager;
    private List<Object> recordsToAdd;
    private List<Object> recordsToUpdate;

    private CrudHandler(ICrudMethods crudMethods, ConnectorManager<?> connectorManager) {
        this.crudMethods = crudMethods;
        this.connectorManager = connectorManager;

        recordsToAdd = new ArrayList<>();
        recordsToUpdate = new ArrayList<>();
    }

    /**
     * Initializes new CrudHandler class.
     *
     * @param crudMethods      - API of basic crud methods (create, read, update, delete).
     * @param connectorManager - manager of connection between java and database
     * @return CrudHandler
     */
    public static CrudHandler initializeCrudHandler(ICrudMethods crudMethods, ConnectorManager<?> connectorManager) {
        return new CrudHandler(crudMethods, connectorManager);
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
        try (Session session = connectorManager.getSession()) {
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
        try (Session session = connectorManager.getSession()) {
            crudMethods.initializeSession(session);
            crudMethods.delete(record);
            connectorManager.commitAndClose();
        } catch (SessionInitializationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Commits and close session.
     */
    public void commitAndClose() {
        try {
            connectorManager.commitAndClose(recordsToAdd, recordsToUpdate);
        } catch (SessionInitializationException e) {
            e.printStackTrace();
        }
    }
}