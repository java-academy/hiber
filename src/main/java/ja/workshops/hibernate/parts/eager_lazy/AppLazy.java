package ja.workshops.hibernate.parts.eager_lazy;


import ja.workshops.hibernate.parts.connectors.H2Connector;
import ja.workshops.hibernate.parts.model.Bookstore;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *  Here is an example of lazy loading.
 *  TODO: start program and see what will happen
 *  TODO: than comment 39 line, uncomment 37 and start again
 *  What did you see? What queries did Hibernate run?
 *  Is there a problem? Why/why not?
 *
 * @author Ola Podorska
 */
public class AppLazy {
    public static void main(String[] args) {
        Session session = new H2Connector().getSession();
        Transaction transaction = session.beginTransaction();
        Bookstore bookstore1 = new Bookstore("name");
        session.save(bookstore1);

        transaction.commit();

        session.close();

        session = new H2Connector("update").getSession();
        transaction = session.beginTransaction();
        Bookstore bookstore = session.get(Bookstore.class, 1L);
        transaction.commit();
//        session.close();
        System.out.println("--> my bookstore: " + bookstore);
        session.close();
    }
}
