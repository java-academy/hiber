package ja.workshop.hibernate.crud;

import ja.workshop.hibernate.connectors.ConnectorManager;
import ja.workshop.hibernate.connectors.SessionInitializationException;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Kamil Rojek
 */
public class CrudHandler {
    private ICrudMethods crudMethods;
    private ConnectorManager connectorManager;
    private List<Object> recordsToAdd;
    private List<Object> recordsToUpdate;

    private CrudHandler(ICrudMethods crudMethods, ConnectorManager connectorManager) {
        this.crudMethods = crudMethods;
        this.connectorManager = connectorManager;

        recordsToAdd = new ArrayList<>();
        recordsToUpdate = new ArrayList<>();
    }

    public static CrudHandler initiliazieCrudHandler(ICrudMethods crudMethods, ConnectorManager connectorManager) {
        return new CrudHandler(crudMethods, connectorManager);
    }

    public CrudHandler addRecord(Collection<?> records) {
        for (Object r : records) {
            addRecord(r);
        }
        return this;
    }

    public <R> CrudHandler addRecord(R record) {
        recordsToAdd.add(record);
        return this;
    }


    public CrudHandler updateRecord(Collection<?> records) {
        for (Object r : records) {
            updateRecord(r);
        }
        return this;
    }

    public <R> CrudHandler updateRecord(R record) {
        recordsToUpdate.add(record);
        return this;
    }

    public <T extends Serializable> Object readRecord(Class clas, T id) {
        try (Session session = connectorManager.getSession()) {
            crudMethods.initializeSession(session);
            return crudMethods.read(clas, id);
        } catch (SessionInitializationException e) {
            e.printStackTrace();
            return null;
        }
    }

    public <R> void deleteRecord(R record) {
        try (Session session = connectorManager.getSession()) {
            crudMethods.initializeSession(session);
            crudMethods.delete(record);
            connectorManager.commitAndClose();
        } catch (SessionInitializationException e) {
            e.printStackTrace();
        }
    }

    public void commitAndClose() {
        try {
            connectorManager.commitAndClose(recordsToAdd, recordsToUpdate);
        } catch (SessionInitializationException e) {
            e.printStackTrace();
        }
    }
}
