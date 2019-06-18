package ja.workshops.hibernate.parts.entity_manager_persistence_xml.connectors;


import java.util.Collection;
import java.util.List;

/**
 * Manages connection and operations between Java and Database.
 *
 * @param <T> type of {@link ISession} connector.
 * @author Kamil Rojek
 * @author Agnieszka Trzewik
 */
public abstract class ConnectorManager<T extends ISession> {
    protected T connector;
    protected List<Object> records;

    protected ConnectorManager(T connector) {
        this.connector = connector;
    }

    protected ConnectorManager() {
    }

    /**
     * Add record to list that will be persisted.
     *
     * @param records list of records to be added.
     * @return {@link ConnectorManager}
     */
    public ConnectorManager<T> addRecords(Collection<?> records) {
        for (Object r : records) {
            addRecord(r);
        }
        return this;
    }

    /**
     * Add record to list that will be persisted.
     *
     * @param record record to be added
     * @param <R>    type of enity
     */
    private <R> void addRecord(R record) {
        records.add(record);
    }

    /**
     * Add record to list that will be persisted.
     *
     * @param record record to be added
     * @param <R>    type of enity
     * @return {@link ConnectorManager}
     */
    public <R> ConnectorManager<T> addRecords(R record) {
        addRecord(record);
        return this;
    }

    /**
     * Commits objects into database and closes session.
     *
     * @throws SessionInitializationException- thrown when error occurs during session initialization.
     * @throws SessionCloseException-          thrown when error occurs during closing session.
     * @throws EntityPersistanceException-     thrown when error occurs during entity persistence.
     */
    public abstract void commitAndClose() throws SessionInitializationException, SessionCloseException, EntityPersistanceException;

}