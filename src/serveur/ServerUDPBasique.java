package serveur;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class ServerUDPBasique extends ServerBasique{

	
	public static void main(String[] args) {

		try{
		 
			//DatagramSocket serverSocket = new DatagramSocket(9876); // ouvrir port 9876 
			DatagramSocket serverSocket = Singleton.getServer();	// ouvrir port 9876 
				
			byte[] receiveData = new byte[1024];	// tableau pour recevoir donn�es
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			serverSocket.receive(receivePacket);	// attente message
			String message = new String(receiveData);	// conversion bytes en String
			System.out.println(message);
			
			InetAddress adresseClient = receivePacket.getAddress(); // get adresse client
			int port = receivePacket.getPort(); // get port client
			
			String reponse = new String("reponse");	// pr�pare r�ponse
			byte[] bytes = reponse.getBytes();		// convertir r�ponse en byte[]
			DatagramPacket sendPacket = 			// pr�pare le paquet
					new DatagramPacket(bytes, bytes.length, adresseClient, port);
			
			serverSocket.send(sendPacket);			// envoi paquet
			
		}catch(Exception e){
			e.printStackTrace();
		}
		

	}

}
