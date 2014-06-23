package clientServer;

import java.io.IOException;
import java.net.ServerSocket;

public class SingletonConnection {
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
