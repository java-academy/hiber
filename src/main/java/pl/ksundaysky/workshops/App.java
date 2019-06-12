package pl.ksundaysky.workshops;
import pl.ksundaysky.workshops.connectors.ConnectorManager;
import pl.ksundaysky.workshops.connectors.H2Connector;
import pl.ksundaysky.workshops.connectors.SessionConnector;
import pl.ksundaysky.workshops.crud.CrudMethods;
import pl.ksundaysky.workshops.model.*;

/**
 * @author Kamil Rojek
 */
public class App {
    public static void main(String[] args)
    {
        Warrior warrior = new Warrior("Wojownik", Sex.MALE, 100);
        Wizard wizard = new Wizard("Czarodziejka", Sex.FEMALE, 100);
        SoulMaster soulMaster = new SoulMaster("Soul Master", Sex.MALE, 100, WizzarUltimate.GHOSTS);
        DarkKnight darkKnight = new DarkKnight("Dark Master", Sex.MALE, 100, WarriorUltimates.KOMBO);

        connect(new H2Connector())
                .openCrudSession(new CrudMethods())
                .addRecord(warrior)
                .addRecord(wizard)
                .addRecord(soulMaster)
                .addRecord(darkKnight)
                .commitAndClose();
    }
    private static ConnectorManager connect(SessionConnector connector) {
        return ConnectorManager.connect(connector);
    }
}
