package serveur;

import java.net.DatagramSocket;

public class Singleton{
	
	private static DatagramSocket server;
	static boolean serverExists = false;

	public static DatagramSocket getServer(int port) throws Exception{
		if(serverExists == false){
			server = new DatagramSocket(port);
			serverExists = true;
		}
		return server;
	}
	
}
