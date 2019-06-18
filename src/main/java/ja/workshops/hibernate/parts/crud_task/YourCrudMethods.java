package ja.workshops.hibernate.parts.crud_task;

import ja.workshops.hibernate.parts.crud.CrudMethodsInterface;
import org.hibernate.Session;

import java.io.Serializable;

/**
 * @author Kamil Rojek
 */
class YourCrudMethods implements CrudMethodsInterface {
    private Session session;

    @Override
    public void initializeSession(Session session) {
        this.session = session;
    }

    @Override
    public <R> void create(R record) {

    }

    @Override
    public <T extends Serializable> Object read(Class<?> clazz, T id) {
        return null;
    }

    @Override
    public <R> void update(R record) {

    }

    @Override
    public <R> void delete(R record) {

    }
}
