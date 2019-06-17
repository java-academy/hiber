package ja.worshops.hibernate.parts;

import ja.workshops.hibernate.parts.model.Author;
import ja.workshops.hibernate.parts.model.Book;
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
        //TODO: Implement these authors and add them as the authors of the book:
        Author author1;
        Author author2;

        book = new Book();

    }

    @Test
    public void collectionIsOfTypeHashSet() {
        //TODO: Prove that book.getAuthors() is a java.util.HashSet:

        //Arrange

        //Act

        //Assert
    }

    @Test
    public void persistingHashSetGivesHibernatePersistentSet() {
        //TODO: Prove that after book persistence book.getAuthors() is an org.hibernate.collection.internal.PersistentSet:

        //Arrange

        //Act

        //Assert
    }
}
