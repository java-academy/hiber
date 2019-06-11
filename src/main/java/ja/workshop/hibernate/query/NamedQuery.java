package ja.workshop.hibernate.query;

import ja.workshop.hibernate.model.Author;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author krzysztof.niedzielski
 */

//TODO : zmienic na inny
public class NamedQuery implements IQuery {
    public <T> List<T> listAll(Session session, Class T ){
        Query<T> query = session.createNamedQuery("SelectAllAuthors",T);
        return query.getResultList();
    }

    @Override
    public List<Author> listAllAuthorsWithSpecifiedName(Session session, String name) {

        Query<Author> query = session.createNamedQuery("SelectAuthorsWhereName",Author.class);
        query.setParameter("authorName",name);
        return query.getResultList();
    }
}
