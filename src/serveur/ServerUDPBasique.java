package serveur;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class ServerUDPBasique implements ServerBasique{

	
	public static void main(String[] args) {

		try{
		 
			
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

	@Override
	public boolean ouvrirConnection(int port) { 
		DatagramSocket serverSocket = Singleton.getServer(port); 
		return false;
	}

	@Override
	public boolean envoyer(String message) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String recevoir() {
		// TODO Auto-generated method stub
		return null;
	}

}
