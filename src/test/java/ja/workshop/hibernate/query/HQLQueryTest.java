package ja.workshop.hibernate.query;

import ja.workshop.hibernate.connectors.ConnectorManager;
import ja.workshop.hibernate.connectors.H2Connector;
import ja.workshop.hibernate.connectors.SessionInitializationException;
import ja.workshop.hibernate.model.Author;
import ja.workshop.hibernate.model.Book;
import ja.workshop.hibernate.model.Genre;
import org.hibernate.Session;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ja.workshop.hibernate.crud.CrudMethods;

import java.util.List;
import java.util.Set;

import static org.testng.Assert.*;

/**
 * @author krzysztof.niedzielski
 */
public class HQLQueryTest {


    private Session session;
    private IQuery iQuery;

    @BeforeClass
    public void before() throws SessionInitializationException {
        Author author = new Author("Kamil", "R");
        Set<Author> authors = Set.of(new Author("Jan", "Brzechwa"), new Author("OLA", "POD"));
        Book book = new Book("BOOK", authors, Genre.CLASSIC);
        ConnectorManager.connect(new H2Connector())
                .openCrudSession(new CrudMethods())
                .updateRecord(author)
                .updateRecord(authors)
                .updateRecord(book)
                .commitAndClose();
        this.session = ConnectorManager.connect(new H2Connector("update")).getSession();
        iQuery= new HQLQuery();
    }

    @Test(priority = 2)
    public void testListAll() {
        List<Author> list = iQuery.listAll(this.session,Author.class);
        System.out.println(list);
        assertEquals( list.size(),3);
    }

    @Test(priority = 3)
    public void testListAllAuthorsWithSpecifiedName() {
        List<Author> list = iQuery.listAllAuthorsWithSpecifiedName(this.session,"Kamil");
        assertEquals( list.size(),1);
        session.close();
    }
}