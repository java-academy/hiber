package ja.workshops.hibernate.parts.lifecycle;

import ja.workshops.hibernate.parts.connectors.H2Connector;
import ja.workshops.hibernate.parts.model.Author;
import org.hibernate.Session;
import org.hibernate.Transaction;

import static ja.workshops.hibernate.parts.lifecycle.EntityDrawer.*;

/**
 * Main method shows hibernate objects in each state and how it changes after specific operations
 * TODO: create new class and use basic methods to obtain the same lifecycle.
 * <p>
 * Lifecycle will be useful in collections task!
 *
 * @author Ola Podorska
 */
class App {
    public static void main(String[] args) {
        //creating objects used for demonstration
        Author firstAuthor = new Author("first name", "first surname");
        Author secondAuthor = new Author("second name", "second surname");
        Author thirdAuthor = new Author("third name", "third surname");

        //starts connection and begins transaction
        Session session = new H2Connector().getSession();
        Transaction transaction = session.beginTransaction();
        showEntities("BEFORE SAVE:", session);

        //saving three records in database -> creating new objects and make them persistent
        session.save(firstAuthor);
        session.save(secondAuthor);
        session.save(thirdAuthor);
        showEntities("AFTER SAVE:", session);

        //get two records from database (you could also use find() or load() methods)
        firstAuthor = session.get(Author.class, 1L);
        thirdAuthor = session.get(Author.class, 3L);
        displayAuthorsName("Get name from Database:", firstAuthor);
        displayAuthorsName("Get name from Database:", thirdAuthor);

        //evict three objects - Hibernate doesn't see them, because we removed them from it's cache
        //detached state
        session.evict(firstAuthor);
        session.evict(secondAuthor);
        session.evict(thirdAuthor);
        showEntities("AFTER EVICT:", session);

        //change two objects
        firstAuthor.setName("first name change");
        thirdAuthor.setName("third name change");

        //refresh session
        session.flush();

        //check if objects were changed
        firstAuthor = session.get(Author.class, 1L);
        thirdAuthor = session.get(Author.class, 3L);
        displayAuthorsName("Name after evict:", firstAuthor);
        displayAuthorsName("Name after evict:", thirdAuthor);

        //merge two objects -> they return to persistent state
        session.merge(firstAuthor);
        session.merge(thirdAuthor);
        showEntities("AFTER MERGE:", session);

        //change two objects
        firstAuthor.setName("first name change change");
        thirdAuthor.setName("third name change change");
        session.flush();
        firstAuthor = session.get(Author.class, 1L);
        thirdAuthor = session.get(Author.class, 3L);
        displayAuthorsName("Name after merge:", firstAuthor);
        displayAuthorsName("Name after merge:", thirdAuthor);

        //find second author by invoking load() method
        Author secondAuthorReloaded = new Author();
        session.load(secondAuthorReloaded, 2L);
        displayAuthorsName("To delete:", secondAuthorReloaded);

        //delete object from Hibernate cache and database
        session.delete(secondAuthorReloaded);
        showEntities(",AFTER DELETE", session);
        secondAuthorReloaded = session.get(Author.class, 2L);

        //after deletion
        print(secondAuthorReloaded.toString());
        transaction.commit();
        session.close();
    }
}
