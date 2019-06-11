package ja.worshop.hibernate;

import ja.workshop.hibernate.connectors.H2Connector;
import ja.workshop.hibernate.connectors.SessionConnector;
import ja.workshop.hibernate.model.Author;
import ja.workshop.hibernate.model.Book;
import ja.workshop.hibernate.model.Genre;
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
    public void givenJavaHashSet_ThenReturnJavaHashSet(){

        //Arrange

        //Act

        //Assert
        assertEquals(book.getAuthors().getClass(), HashSet.class);
    }

    @Test
    public void givenJavaHashSet_ThenReturnHibernatePersistentSet(){

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
