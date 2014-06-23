package clientServer;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Applicaion du design pattern singleton pour manipuler une instance unique du serveur
 * @author charroux
 *
 */
public class SingletonTCPConnection {
	static{
		try {
			listennerSocket = new ServerSocket(6789); // ouverture port 6789
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	static ServerSocket listennerSocket;
	/**
	 * @return toujours la même connection
	 */
	public static ServerSocket getListennerSocket() {
		return listennerSocket;
	}
	
}
