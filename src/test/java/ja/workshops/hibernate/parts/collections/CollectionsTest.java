package ja.workshops.hibernate.parts.collections;

import ja.workshops.hibernate.parts.connectors.H2Connector;
import ja.workshops.hibernate.parts.connectors.SessionConnector;
import ja.workshops.hibernate.parts.model.Author;
import ja.workshops.hibernate.parts.model.Book;
import ja.workshops.hibernate.parts.model.Genre;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.collection.internal.PersistentSet;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.assertEquals;

/**
 * @author Agnieszka Trzewik
 */
@Test
public class CollectionsTest {

    private Book book;

    @BeforeMethod
    public void initialize(){
        Author author1 = new Author("Anna", "Kowalska");
        Author author2 = new Author("Maria", "Nowak");
        Set<Author> authors = new HashSet<>();
        authors.add(author1);
        authors.add(author2);
        book = new Book("Fikcyjna podróż", authors, Genre.FANTASY);
    }

    @Test
    public void collectionIsOfTypeHashSet(){

        //Arrange

        //Act

        //Assert
        assertEquals(book.getAuthors().getClass(), HashSet.class);
    }

    @Test
    public void persistingHashSetGivesHibernatePersistentSet(){

        //Arrange
        SessionConnector sessionConnector = new H2Connector();
        Session session = sessionConnector.getSession();
        Transaction transaction = session.beginTransaction();

        //Act
        session.persist(book);

        transaction.rollback();
        session.close();

        //Assert
        assertEquals(book.getAuthors().getClass(), PersistentSet.class);
    }
}
