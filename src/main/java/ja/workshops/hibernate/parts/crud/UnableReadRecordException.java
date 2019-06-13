package ja.workshops.hibernate.parts.crud;

/**
 * Thrown when can't read record from database.
 *
 * @author Ola Podorska
 */
class UnableReadRecordException extends Exception {
    UnableReadRecordException(String message) {
        super(message);
    }
}
