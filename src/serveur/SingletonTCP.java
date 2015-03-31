package serveur;

import java.net.DatagramSocket;
import java.net.ServerSocket;

public class SingletonTCP{
	
	private static ServerSocket server;
	private static boolean serverExists = false;

	public static ServerSocket getServer(int port) throws Exception{
		if(serverExists == false){
			server = new ServerSocket(port);
			serverExists = true;
		}
		return server;
	}
	
}
