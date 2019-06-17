package ja.workshops.hibernate.parts.queries.query;

import ja.workshops.hibernate.parts.model.Author;
import org.hibernate.Session;

import java.util.List;

/**
 * @author krzysztof.niedzielski
 */
public interface IQuery {
     <T> List<T> listAll(Session session, Class T);

     List<Author> listAllAuthorsWithSpecifiedName(Session session, String name);
}
