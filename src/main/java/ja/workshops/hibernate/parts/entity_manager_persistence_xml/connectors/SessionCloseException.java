package ja.workshops.hibernate.parts.entity_manager_persistence_xml.connectors;


/**
 * Exception thrown when Session can't be closed.
 *
 * @author Kamil Rojek
 */
public class SessionCloseException extends Exception {
    public SessionCloseException(String message) {
        super(message);
    }
}
