package ja.workshop.hibernate;

import ja.workshop.hibernate.connectors.ConnectorManager;
import ja.workshop.hibernate.connectors.H2Connector;
import ja.workshop.hibernate.connectors.SessionConnector;
import ja.workshop.hibernate.connectors.SessionInitializationException;
import ja.workshop.hibernate.crud.CrudMethods;
import ja.workshop.hibernate.model.Author;
import ja.workshop.hibernate.model.Book;
import ja.workshop.hibernate.model.Genre;
import org.hibernate.Session;

import java.util.Set;

/**
 * @author Kamil Rojek
 */
public class App {
    public static void main(String[] args) throws SessionInitializationException {
        Author author = new Author("Kamil", "R");
        Set<Author> authors = Set.of(new Author("Jan", "Brzechwa"), new Author("OLA", "POD"));
        Book book = new Book("BOOK", authors, Genre.CLASSIC);

        connect(new H2Connector())
                .openCrudSession(new CrudMethods())
                .updateRecord(author)
                .updateRecord(authors)
                .updateRecord(book)
                .commitAndClose();

        //TODO : You should implement methods listAll and listAllAuthorsWithSpecifiedName in all classes in package ja.workshop.hibernate.query
        // You can achieve this in several ways.
        // In this package there are several classes that need implementation.
        // Names of this classes are not random, they correspond to the way you should implement each class.
        // All test should pass.

        Session session = connect(new H2Connector("update")).getSession();

    }

    private static ConnectorManager connect(SessionConnector connector) {
        return ConnectorManager.connect(connector);
    }
}
