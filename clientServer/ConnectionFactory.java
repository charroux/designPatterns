package clientServer;

import java.net.DatagramSocket;
import java.net.ServerSocket;

public class ConnectionFactory {
	 
	public enum Protocol{
		UDP,
		TCP
	}
	
	public Object getConnection(String adresse, Protocol protocol) throws Exception{
		if(protocol == Protocol.TCP){
			// cr�er un serveur TCP
			ServerSocket listennerSocket = SingletonConnection.getListennerSocket();
			return listennerSocket;
		} else {
			// cr�er un serveur UDP
			DatagramSocket serverSocket = new DatagramSocket(9876); // ouvrir port 9876
			return serverSocket;
		}
	}

}
