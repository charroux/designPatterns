package clientServer.singleton;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;

/**
 * Applicaion du design pattern singleton pour manipuler une instance unique du serveur
 * @author charroux
 *
 */
public class SingletonUDPConnection {
	static{
		try {
			serverSocket = new DatagramSocket(9876); // ouvrir port 9876
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	static DatagramSocket serverSocket;
	/**
	 * @return toujours la même connection
	 */
	public static DatagramSocket getServerSocket() {
		return serverSocket;
	}
	
	
}
