package ja.workshops.hibernate.parts.entity_manager_persistence_xml;


import ja.workshops.hibernate.parts.model.Author;
import ja.workshops.hibernate.parts.model.Book;
import ja.workshops.hibernate.parts.model.Genre;

import java.util.Set;

/**
 * Wpierw zerknij na //FIXME na dole pliku (nad catch)
 * Powinieneś wtedy dostać błąd kompilacji. Zauważ do czego się on odnosi.
 * <p>
 * Odkomentuj te linijki, które odnoszą się do danego,
 * skonfigurowanego uprzednio przez Ciebie, Entity Managera,
 * czyli te, które wykonają zapis, commit i zamknięcie połączenia.
 *
 * @author Kamil Rojek
 */
public class App {
    public static void main(String[] args) {
//
//        ConnectorManager<MysqlConnector> connectorManagerMySQL = EntityManagerConnectorManager.of(new MysqlConnector());
//        ConnectorManager<PostgreSQLConnector> connectorManagerPostgreSQL = EntityManagerConnectorManager.of(new PostgreSQLConnector());
//        ConnectorManager<H2Connector> connectorManagerH2 = EntityManagerConnectorManager.of(new H2Connector());

        Author author = new Author("Julian", "Tuwim");
        Set<Author> authors = Set.of(new Author("Stanisław", "Lem"), new Author("Edmund", "Niziurski"));
        Book book = new Book("Siódme wtajemniczenie", authors, Genre.CLASSIC);
//
//        connectorManagerMySQL.addRecords(author);
//        connectorManagerMySQL.addRecords(authors);
//        connectorManagerMySQL.addRecords(book);
//
//        connectorManagerPostgreSQL.addRecords(author);
//        connectorManagerPostgreSQL.addRecords(authors);
//        connectorManagerPostgreSQL.addRecords(book);

//        connectorManagerH2.addRecords(author);
//        connectorManagerH2.addRecords(authors);
//        connectorManagerH2.addRecords(book);


        try {
//            connectorManagerMySQL.commitAndClose();
//            connectorManagerPostgreSQL.commitAndClose();
//            connectorManagerH2.commitAndClose();

// FIXME: zastąp catch Exception e multicatchem - powinieneś mieć błąd kompilacji
//        } catch (SessionInitializationException | SessionCloseException | EntityPersistenceException e) {
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }


    }
}