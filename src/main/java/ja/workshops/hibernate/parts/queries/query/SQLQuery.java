package ja.workshops.hibernate.parts.queries.query;

import ja.workshops.hibernate.parts.model.Author;
import org.hibernate.Session;

import java.util.List;

/**
 * Documentation:
 * Session : https://docs.jboss.org/hibernate/orm/5.4/javadocs/
 * Tip: createSqlQuery()
 * createSqlQuery returns List<Object[]> so we have to parse Object[] to Author object.
 * @author krzysztof.niedzielski
 */
public class SQLQuery {

    public List<Author> listAll(Session session) {
        // TODO: Implement me!
        return null;
    }

    public List<Author> listAllAuthorsWithSpecifiedName(Session session, String name) {
        // TODO: Implement me!
        return null;
    }

}
