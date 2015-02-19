package serveur;

import java.net.DatagramSocket;

public class Singleton{
	
	private static DatagramSocket server;
	
	static{
		try{
			server = new DatagramSocket(9876);
		}catch(Exception e){
			e.printStackTrace();
		}
	}	 

	public static DatagramSocket getServer(){
		return server;
	}
	
	public static void main(String[] a){
		int i;
		i = 0;
		DatagramSocket socket1 = Singleton.getServer();
		DatagramSocket socke2 = Singleton.getServer();
	}
}
