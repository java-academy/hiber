package ja.workshops.hibernate.parts.entity_manager_persistence_xml.connectors;


/**
 * Exception thrown when Session can't be initialized.
 *
 * @author Kamil Rojek
 */
public class SessionInitializationException extends Exception {
    public SessionInitializationException(String message) {
        super(message);
    }
}
