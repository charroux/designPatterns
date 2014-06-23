package clientServer;

import java.net.DatagramSocket;
import java.net.ServerSocket;

/**
 * Utilisation du pattern factory pour masquer 2 implantations de classes complexes :
 * 	- Serveur TCP
 * 	- Serveur UDP
 * @author charroux
 *
 */
public class ConnectionFactory {
	 
	public enum Protocol{
		UDP,
		TCP
	}
	
	public static Object getConnection(String adresse, Protocol protocol) throws Exception{
		if(protocol == Protocol.TCP){
			// créer un serveur TCP
			ServerSocket listennerSocket = SingletonConnection.getListennerSocket();
			return listennerSocket;
		} else {
			// créer un serveur UDP
			DatagramSocket serverSocket = new DatagramSocket(9876); // ouvrir port 9876
			return serverSocket;
		}
	}

}
