package ja.workshop.hibernate.query;

import ja.workshop.hibernate.model.Author;
import org.hibernate.Session;

import java.util.List;

/**
 * Documentation :
 * - CriteriaBuilder: https://docs.oracle.com/javaee/7/api/javax/persistence/criteria/CriteriaBuilder.html
 * - Root : https://docs.oracle.com/javaee/7/api/javax/persistence/criteria/Root.html
 * - CriteriaQuery: https://docs.oracle.com/javaee/7/api/javax/persistence/criteria/CriteriaQuery.html
 * - TypedQuery : https://docs.oracle.com/javaee/7/api/javax/persistence/TypedQuery.html
 * @author krzysztof.niedzielski
 */
public class CriteriaApi implements IQuery {
    @Override
    public <T> List<T> listAll(Session session, Class T ){
       return null;
    }

    @Override
    public List<Author> listAllAuthorsWithSpecifiedName(Session session, String name) {
        return null;
    }
}
