package ja.worshop.hibernate;

import ja.workshop.hibernate.model.Author;
import ja.workshop.hibernate.model.Book;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Agnieszka Trzewik
 */
@Test
public class CollectionsTest {

    private Book book;


    @BeforeMethod
    public void initialize() {
        //TODO: IImplement these authors and add them as the authors of the book:
        Author author1;
        Author author2;

        book = new Book();

    }

    @Test
    public void givenJavaHashSet_ThenReturnJavaHashSet() {
        //TODO Prove that book.getAuthors() is a java.util.HashSet:

        //Arrange

        //Act

        //Assert
    }

    @Test
    public void givenJavaHashSet_ThenReturnHibernatePersistentSet() {
        //TODO Prove that after book persistence book.getAuthors() is an org.hibernate.collection.internal.PersistentSet:

        //Arrange

        //Act

        //Assert
    }
}
