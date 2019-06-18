package ja.workshops.hibernate.parts.lifecycle;

import ja.workshops.hibernate.parts.model.Author;
import org.hibernate.Session;
import org.hibernate.engine.spi.EntityEntry;
import org.hibernate.engine.spi.SessionImplementor;

import java.util.Map;

/**
 * Utility class displaying entities in given session
 *
 * @author Ola Podorska
 */
class EntityDrawer {

    private static Map.Entry<Object, EntityEntry>[] getEntities(Session session) {
        return ((SessionImplementor) session).getPersistenceContext().reentrantSafeEntityEntries();
    }

    static void showEntities(String messageToDisplay, Session session) {
        System.out.println();
        System.out.println(messageToDisplay);
        Map.Entry<Object, EntityEntry>[] entities = getEntities(session);
        System.out.println("Entities in Session:");
        for (Map.Entry<Object, EntityEntry> entity : entities
        ) {
            System.out.println(entity.getKey() + " " + entity.getValue());
        }
        System.out.println();
    }

    static void displayAuthorsName(String message, Author author) {
        System.out.println(message + " " + author.getName());
    }

    static void print(String message){
        System.out.println(message);
    }
}
