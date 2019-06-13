package ja.workshops.hibernate.parts.eager_lazy;


import ja.workshops.hibernate.parts.connectors.ConnectorManager;
import ja.workshops.hibernate.parts.connectors.H2Connector;
import ja.workshops.hibernate.parts.model.Author;
import ja.workshops.hibernate.parts.model.Book;
import ja.workshops.hibernate.parts.model.Genre;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Here is an example of eager loading.
 * TODO: start program and see what will happen
 * TODO: then comment 49 line, uncomment 46 and start again
 * What did you see? What queries did Hibernate?
 * --> When you are done, go to AppLazy class
 *
 * @author Ola Podorska
 */
public class AppEager {
    public static void main(String[] args) {
        ConnectorManager.connect(new H2Connector());
        Session session = new H2Connector().getSession();
        Transaction transaction = session.beginTransaction();
        Author author1 = new Author("imie1", "nazwisko1");
        Author author2 = new Author("imie2", "nazwisko2");
        Author author3 = new Author("imie3", "nazwisko3");
        Book book1 = new Book("tytul1", new HashSet<>(Arrays.asList(author1)), Genre.CLASSIC);
        Book book2 = new Book("tytul2", new HashSet<>(Arrays.asList(author1)), Genre.CLASSIC);
        Book book3 = new Book("tytul3", new HashSet<>(Arrays.asList(author2)), Genre.CLASSIC);

        session.save(author1);
        session.save(author2);
        session.save(author3);
        session.save(book1);
        session.save(book2);
        session.save(book3);

        transaction.commit();

        session.close();

        session = new H2Connector("update").getSession();
        transaction = session.beginTransaction();
        Book book = session.get(Book.class, 1L);
        transaction.commit();
//        session.close();
        System.out.println("--> my book: " + book);
        System.out.println("--> authors: " + book.getAuthors());
        session.close();
    }
}
