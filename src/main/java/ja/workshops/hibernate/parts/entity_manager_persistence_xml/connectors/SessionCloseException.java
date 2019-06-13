package ja.workshops.hibernate.parts.entity_manager_persistence_xml.connectors;

/**
 * @author Kamil Rojek
 */
public class SessionCloseException extends Exception {
    public SessionCloseException(String message) {
        super(message);
    }
}
