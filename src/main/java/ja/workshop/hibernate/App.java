package ja.workshop.hibernate;

import ja.workshop.hibernate.connectors.H2Connector;
import ja.workshop.hibernate.connectors.MysqlConnector;
import ja.workshop.hibernate.connectors.PostgresConnector;
import ja.workshop.hibernate.model.Author;
import ja.workshop.hibernate.model.Book;
import ja.workshop.hibernate.model.Genre;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Set;

/**
 * @author krzysztof.niedzielski
 */
public class App {
    public static void main(String[] args) {

        Author author = new Author("Marian", "Biały");
        Author author1 = new Author("Dariusz", "Nikodemski");
        Book book = new Book("Ranki", Set.of(author, author1), Genre.CLASSIC);

        Session session = new PostgresConnector().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(author);
        session.save(author1);
        session.save(book);
        transaction.commit();
        session.close();

        Session session2 = new MysqlConnector().getSession();
        Transaction transaction2 = session2.beginTransaction();

        session2.save(author);
        session2.save(author1);
        session2.save(book);
        transaction2.commit();
        session2.close();


        Session session3 = new H2Connector().getSession();
        Transaction transaction3 = session3.beginTransaction();

        session3.save(author);
        session3.save(author1);
        session3.save(book);
        transaction3.commit();
        session3.close();
    }
}
