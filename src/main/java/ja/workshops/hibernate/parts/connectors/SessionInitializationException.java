package ja.workshops.hibernate.parts.connectors;

/**
 * Exception thrown when Session can't be initialized.
 *
 * @author Kamil Rojek
 */
public class SessionInitializationException extends Exception {
    SessionInitializationException(String message) {
        super(message);
    }
}
