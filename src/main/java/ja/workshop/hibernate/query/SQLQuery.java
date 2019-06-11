package ja.workshop.hibernate.query;

import org.hibernate.Session;
import ja.workshop.hibernate.model.Author;

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
        return null;
    }

    public List<Author> listAllAuthorsWithSpecifiedName(Session session, String name) {
        return null;
    }

}
