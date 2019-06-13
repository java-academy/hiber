package ja.workshops.hibernate.parts.lifecycle;

import ja.workshops.hibernate.parts.connectors.H2Connector;
import ja.workshops.hibernate.parts.model.Author;
import org.hibernate.Session;
import org.hibernate.Transaction;

import static ja.workshops.hibernate.parts.lifecycle.EntityDrawer.showEntities;

/**
 * This class shows hibernate object in each state.
 * TODO: create new class and use basic methods to obtain the same lifecycle.
 * <p>
 * Lifecycle will be useful in collections task!
 *
 * @author Ola Podorska
 */
class App {
    public static void main(String[] args) {
        //starts connection and begins transaction
        Session session = new H2Connector().getSession();
        Transaction transaction = session.beginTransaction();
        System.out.println("BEFORE SAVE:");
        showEntities(session);

        //save three records in database -> create new objects and make them persistent
        Author author1 = new Author("first name", "first surname");
        Author author2 = new Author("second name", "second surname");
        Author author3 = new Author("third name", "third surname");
        session.save(author1);
        session.save(author2);
        session.save(author3);
        System.out.println("\nAFTER SAVE:");
        showEntities(session);

        //get two records from database (you could also use find() or load() methods)
        author1 = session.get(Author.class, 1L);
        author3 = session.get(Author.class, 3L);
        System.out.println("Get name from Database:" + author1.getName());
        System.out.println("Get name from Database:" + author3.getName());

        //evict three objects - Hibernate doesn't see them, because we removed them from it's cache
        //detached state
        session.evict(author1);
        session.evict(author2);
        session.evict(author3);
        System.out.println("\nAFTER EVICT:");
        showEntities(session);

        //change two objects
        author1.setName("first name change");
        author3.setName("third name change");

        //refresh session
        session.flush();

        //check if objects were changed
        author1 = session.get(Author.class, 1L);
        author3 = session.get(Author.class, 3L);
        System.out.println("Name after evict:" + author1.getName());
        System.out.println("Name after evict:" + author3.getName());

        //merge two objects -> they return to persistent state
        session.merge(author1);
        session.merge(author3);
        System.out.println("\nAFTER MERGE:");
        showEntities(session);

        //change two objects
        author1.setName("first name change change");
        author3.setName("third name change change");
        session.flush();
        author1 = session.get(Author.class, 1L);
        author3 = session.get(Author.class, 3L);
        System.out.println("name after merge:" + author1.getName());
        System.out.println("name after merge:" + author3.getName());

        //find second author by invoking load() method
        Author secondAuthor = new Author();
        session.load(secondAuthor, 2L);
        System.out.println("to delete: " + secondAuthor);

        //delete object from Hibernate cache and database
        session.delete(secondAuthor);
        System.out.println("\nAFTER DELETE");
        showEntities(session);
        secondAuthor = session.get(Author.class, 2L);

        //after deletion
        System.out.println(secondAuthor);
        transaction.commit();
        session.close();
    }
}
