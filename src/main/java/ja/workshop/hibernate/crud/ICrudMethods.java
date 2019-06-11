package ja.workshop.hibernate.crud;

import org.hibernate.Session;

import java.io.Serializable;

/**
 * @author Kamil Rojek
 */
public interface ICrudMethods {
    void initializeSession(Session session);

    <R> void create(R record);

    <T extends Serializable> Object read(Class c, T Id);

    <R> void update(R record);

    <R> void delete(R record);
}
