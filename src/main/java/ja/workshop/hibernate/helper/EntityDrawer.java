package ja.workshop.hibernate.helper;

import org.hibernate.Session;
import org.hibernate.engine.spi.EntityEntry;
import org.hibernate.engine.spi.SessionImplementor;

import java.util.Map;

/**
 * @author Ola Podorska
 */
public class EntityDrawer {

    private static Map.Entry<Object, EntityEntry>[] getEntities(Session session){
        return ((SessionImplementor) session).getPersistenceContext().reentrantSafeEntityEntries();
    }

    public static void showEntities(Session session){
        Map.Entry<Object, EntityEntry>[] entities = getEntities(session);
        System.out.println("Entities in Session:");
        for (Map.Entry<Object, EntityEntry> entity: entities
        ) {
            System.out.println(entity.getKey() + " " + entity.getValue());
        }
        System.out.println();
    }
}
