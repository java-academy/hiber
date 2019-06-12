package ja.workshop.hibernate.query;

import org.hibernate.Session;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author krzysztof.niedzielski
 */
public class CriteriaApi {

    /**
     * session.createriteria() is depracated from hibernate 5.2
     * @param session
     * @return
     */

    public <T> List<T> listAll(Session session, Class T ){
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(T);
        Root<T> from = criteriaQuery.from(T);

        System.out.println("Select all records");

        CriteriaQuery<T> select = criteriaQuery.select(from);
        TypedQuery<T> typedQuery = session.createQuery(select);
        List<T> resultlist = typedQuery.getResultList();

        return resultlist;
    }
}
