package clientServer.factory;

import java.net.DatagramSocket;
import java.net.ServerSocket;


/**
 * Utilisation du pattern factory pour masquer 2 implantations de classes complexes :
 * 
 * 	- Serveur TCP
 * 	- Serveur UDP
 * 
 * @author charroux
 *
 */
public class ConnectionFactory {
	 
	public enum Protocol{
		UDP,
		TCP
	}
	
	public Connection getConnection(Protocol protocol) throws Exception{
		if(protocol == Protocol.TCP){	// créer un serveur TCP
			Connection connection = new TCP_Connection();
			return connection;
		} else { // créer un serveur UDP
			Connection connection = new UDP_Connection();
			return connection;
		}
	}
	
}
