package ja.workshop.hibernate.connectors;

import java.util.Collection;
import java.util.List;

/**
 * @author Kamil Rojek
 * @author Agnieszka Trzewik
 */
public abstract class ConnectorManager<T extends ISession> {
    protected T connector;
    protected List<Object> records;

    public ConnectorManager<T> addRecords(Collection<?> records) {
        for (Object r : records) {
            addRecord(r);
        }
        return this;
    }

    private <R> void addRecord(R record) {
        records.add(record);
    }

    public <R> ConnectorManager<T> addRecords(R record) {
        addRecord(record);
        return this;
    }

    public abstract void commitAndClose() throws SessionInitializationException, SessionCloseException;

}
