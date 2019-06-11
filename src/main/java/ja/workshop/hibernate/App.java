package ja.workshop.hibernate;

import ja.workshop.hibernate.connectors.ConnectorManager;
import ja.workshop.hibernate.connectors.EntityManager.EntityManagerConnectorManager;
import ja.workshop.hibernate.connectors.EntityManager.H2Connector;
import ja.workshop.hibernate.connectors.EntityManager.MysqlConnector;
import ja.workshop.hibernate.connectors.EntityManager.PostgreSQLConnector;
import ja.workshop.hibernate.connectors.SessionCloseException;
import ja.workshop.hibernate.connectors.SessionInitializationException;
import ja.workshop.hibernate.model.Author;
import ja.workshop.hibernate.model.Book;
import ja.workshop.hibernate.model.Genre;

import java.util.Set;

/**
 * Odkomentuj te linijki,
 * dla których skonfigurowłeś Entity Managera
 *
 * @author Kamil Rojek
 */
public class App {
    public static void main(String[] args) {

        ConnectorManager<MysqlConnector> connectorManagerMySQL = EntityManagerConnectorManager.of(new MysqlConnector());
        ConnectorManager<PostgreSQLConnector> connectorManagerPostgreSQL = EntityManagerConnectorManager.of(new PostgreSQLConnector());
        ConnectorManager<H2Connector> connectorManagerH2 = EntityManagerConnectorManager.of(new H2Connector());

        Author author = new Author("Julian", "Tuwim");
        Set<Author> authors = Set.of(new Author("Stanisław", "Lem"), new Author("Edmund", "Niziurski"));
        Book book = new Book("Siódme wtajemniczenie", authors, Genre.CLASSIC);

        connectorManagerMySQL.addRecords(author);
        connectorManagerMySQL.addRecords(authors);
        connectorManagerMySQL.addRecords(book);

        connectorManagerPostgreSQL.addRecords(author);
        connectorManagerPostgreSQL.addRecords(authors);
        connectorManagerPostgreSQL.addRecords(book);

        connectorManagerH2.addRecords(author);
        connectorManagerH2.addRecords(authors);
        connectorManagerH2.addRecords(book);


        try {
            connectorManagerMySQL.commitAndClose();
            connectorManagerPostgreSQL.commitAndClose();
            connectorManagerH2.commitAndClose();
        } catch (SessionInitializationException | SessionCloseException e) {
            e.getMessage();
        }
    }
}
