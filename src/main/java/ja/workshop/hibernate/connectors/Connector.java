package ja.workshop.hibernate.connectors;

import org.hibernate.Session;

/**
 * @author krzysztof.niedzielski
 */
public interface Connector {

   Session getSession() throws Exception;

}
