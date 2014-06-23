package clientServer;

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
	
	public static Object getConnection(String adresse, Protocol protocol) throws Exception{
		if(protocol == Protocol.TCP){
			// créer un serveur TCP
			ServerSocket listennerSocket = SingletonTCPConnection.getListennerSocket();
			return listennerSocket;
		} else {
			// créer un serveur UDP
			DatagramSocket serverSocket = SingletonUDPConnection.getServerSocket();
			return serverSocket;
		}
	}

}
