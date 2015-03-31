package serveur;

import java.net.DatagramSocket;

public class SingletonUDP{
	
	private static DatagramSocket server;
	private static boolean serverExists = false;

	public static DatagramSocket getServer(int port) throws Exception{
		if(serverExists == false){
			server = new DatagramSocket(port);
			serverExists = true;
		}
		return server;
	}
	
}
