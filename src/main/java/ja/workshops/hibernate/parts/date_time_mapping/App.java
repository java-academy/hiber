package ja.workshops.hibernate.parts.date_time_mapping;

import ja.workshops.hibernate.parts.connectors.ConnectorManager;
import ja.workshops.hibernate.parts.connectors.SessionConnector;


/**
 * @author Agnieszka Trzewik
 */
public class App {

    public static void main(String[] args) {


        //TODO: Implement authors dates of birth:
        //?? dateOfBirth1;
        //?? dateOfBirth2;

        //TODO: Complete implementation with date of addition author to database:
//        Author authorWithDateOfBirth1 = new Author("Anna", "Wajda", dateOfBirth1, ??);
//        Author authorWithDateOfBirth2 = new Author("Stanisław", "Kowalski", dateOfBirth2, ??);

        //TODO: Uncomment after completing previous tasks:
//        Set<Author> authors = new HashSet<>();
//        authors.add(authorWithDateOfBirth1);
//        authors.add(authorWithDateOfBirth2);

        //TODO: Implement book date of issue:
        //?? dateOfIssue;

        //TODO: Uncomment after completing previous tasks:
//        Book bookWithDateOfIssue = new Book("Fantastyczna książka", authors, Genre.FANTASY, dateOfIssue);
//
//        connect(new H2Connector())
//                .openCrudSession(new CrudMethods())
//                .addRecord(authors)
//                .addRecord(bookWithDateOfIssue)
//                .commitAndClose();


    }

    private static ConnectorManager connect(SessionConnector connector) {
        return ConnectorManager.connect(connector);
    }
}
