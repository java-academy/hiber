package ja.workshops.hibernate.parts.version;

import ja.workshops.hibernate.parts.connectors.ConnectorManager;
import ja.workshops.hibernate.parts.connectors.H2Connector;
import ja.workshops.hibernate.parts.connectors.SessionInitializationException;

/**
 *
 * TODO: 1. Create new field version with @Version annotation in BookstoreBook entity
 *       2. Add random object of BookstoreBook to database.
 *       3. Update record, check the version.
 *       4. Create two parallel session which will try to update recently added record.
 *
 * @author Bartełek Kupajski
 */
class App {

    public static void main(String[] args) throws SessionInitializationException {
        ConnectorManager.connect(new H2Connector()).getSession();
    }
}
