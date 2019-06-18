package ja.workshops.hibernate.parts.crud_task;

import ja.workshops.hibernate.parts.connectors.ConnectorManager;
import ja.workshops.hibernate.parts.connectors.H2Connector;
import ja.workshops.hibernate.parts.connectors.SessionConnector;
import ja.workshops.hibernate.parts.model.Author;

import java.util.Set;

/**
 * @author Kamil Rojek
 */
class App {
    public static void main(String[] args) {
        Author author = new Author("Kamil", "R");
        Set<Author> authors = Set.of(
                new Author("Jan", "Brzechwa"),
                new Author("OLA", "POD")
        );

/*
        //I Stage - creating data base.
        connect(new H2Connector())
                .openCrudSession(YourCrudMethods)
                .updateRecord(author)
                .updateRecord(authors)
                .commitAndClose();
*/
/*
        //II Stage - read record.
        Author authorKamil = (Author) connect(new H2Connector())
                .openCrudSession(YourCrudMethods)
                .readRecord(Author.class, 2L);

        System.out.println(authorKamil);
*/
/*
        //III Stage - update record.
        authorKamil.setName("Kamil");
        authorKamil.setName("Rojek");

        connect(new H2Connector())
                .openCrudSession(YourCrudMethods)
                .updateRecord(authorKamil)
                .commitAndClose();

*/
/*

        //IV Stage - remove record.
        connect(new H2Connector())
                .openCrudSession(YourCrudMethods)
                .deleteRecord(authorKamil);

*/
    }

    private static ConnectorManager connect(SessionConnector connector) {
        return ConnectorManager.connect(connector);
    }
}