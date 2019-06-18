package ja.workshops.hibernate.parts.log_solution;

import ja.workshops.hibernate.parts.connectors.H2Connector;
import ja.workshops.hibernate.parts.model.Author;
import ja.workshops.hibernate.parts.model.Book;
import ja.workshops.hibernate.parts.model.Genre;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author krzysztof.niedzielski
 */
public class App {
    public static void main(String[] args) {
        connect();
    }

    private static void connect() {
        try (Session session = new H2Connector().getSession()) {
            Transaction transaction = session.beginTransaction();

            Author brzechwa = new Author("Jan", "Brzechwa");
            Author kupajki = new Author("Bartosz", "Kupajski");
            Author wrupek = new Author("Wiktor", "Wrupek");
            Set<Author> authors = new HashSet<>();
            authors.add(wrupek);
            authors.add(brzechwa);
            authors.add(kupajki);

            Book book1 = new Book("w pustyni i w puszczy", Collections.singleton(brzechwa), Genre.CLASSIC);
            Book book2 = new Book("angular in 5 minutes", authors, Genre.CLASSIC);
            Book book3 = new Book("todo list - html js", Collections.singleton(wrupek), Genre.CLASSIC);
            session.save(book1);
            session.save(book2);
            session.save(book3);
            session.save(brzechwa);
            session.save(kupajki);
            session.save(wrupek);

            transaction.commit();
        }
    }
}
