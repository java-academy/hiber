package ja.workshop.hibernate.query;

import org.hibernate.Session;
import ja.workshop.hibernate.model.Author;

import java.util.List;

/**
 * Documentation:
 * Session : https://docs.jboss.org/hibernate/orm/5.4/javadocs/
 * Tip: createNamedQuery()
 * @author krzysztof.niedzielski
 */
public class NamedQuery implements IQuery {
    @Override
    public <T> List<T> listAll(Session session, Class T ){
       return null;
    }

    @Override
    public List<Author> listAllAuthorsWithSpecifiedName(Session session, String name) {
        return null;
    }
}
