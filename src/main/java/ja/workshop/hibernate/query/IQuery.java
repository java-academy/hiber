package ja.workshop.hibernate.query;

import org.hibernate.Session;
import ja.workshop.hibernate.model.Author;

import java.util.List;

/**
 * @author krzysztof.niedzielski
 */
public interface IQuery {
     <T> List<T> listAll(Session session, Class T );

     List<Author> listAllAuthorsWithSpecifiedName(Session session, String name);
}
