package ja.workshops.hibernate.parts.entity_manager_persistence_xml;


import ja.workshops.hibernate.parts.entity_manager_persistence_xml.connectors.ConnectorManager;
import ja.workshops.hibernate.parts.entity_manager_persistence_xml.connectors.EntityPersistanceException;
import ja.workshops.hibernate.parts.entity_manager_persistence_xml.connectors.SessionCloseException;
import ja.workshops.hibernate.parts.entity_manager_persistence_xml.connectors.SessionInitializationException;
import ja.workshops.hibernate.parts.entity_manager_persistence_xml.connectors.entity_manager.EntityManagerConnectorManager;
import ja.workshops.hibernate.parts.entity_manager_persistence_xml.connectors.entity_manager.H2Connector;
import ja.workshops.hibernate.parts.model.Author;
import ja.workshops.hibernate.parts.model.Book;
import ja.workshops.hibernate.parts.model.Genre;

import java.util.Set;

/**
 * Odkomentuj te linijki,
 * dla których skonfigurowłeś Entity Managera
 *
 * @author Kamil Rojek
 */
public class App {
    public static void main(String[] args) {
//
//        ConnectorManager<MysqlConnector> connectorManagerMySQL = EntityManagerConnectorManager.of(new MysqlConnector());
//        ConnectorManager<PostgreSQLConnector> connectorManagerPostgreSQL = EntityManagerConnectorManager.of(new PostgreSQLConnector());
        ConnectorManager<H2Connector> connectorManagerH2 = EntityManagerConnectorManager.of(new H2Connector());

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
            connectorManagerH2.commitAndClose();
        } catch (SessionInitializationException | SessionCloseException | EntityPersistanceException e) {
            e.getMessage();
        }
    }
}
