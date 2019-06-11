package ja.workshop.hibernate;

import ja.workshop.hibernate.connectors.H2Connector;

/**
 * @author krzysztof.niedzielski
 */
public class App {
    public static void main(String[] args){
        new H2Connector().getSession();
    }
}
