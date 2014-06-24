package clientServer;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import clientServer.factory.ConnectionFactory.Protocol;

public class ServerUDPBasique {

	
	public static void main(String[] args) {

		try{
		 
			DatagramSocket serverSocket = new DatagramSocket(9876); // ouvrir port 9876 
			byte[] receiveData = new byte[1024];	// tableau pour recevoir données
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			serverSocket.receive(receivePacket);	// attente message
			String message = new String(receiveData);	// conversion bytes en String
			System.out.println(message);
			
			InetAddress adresseClient = receivePacket.getAddress(); // get adresse client
			int port = receivePacket.getPort(); // get port client
			
			String reponse = new String("reponse");	// prépare réponse
			byte[] bytes = reponse.getBytes();		// convertir réponse en byte[]
			DatagramPacket sendPacket = 			// prépare le paquet
					new DatagramPacket(bytes, bytes.length, adresseClient, port);
			
			serverSocket.send(sendPacket);			// envoi paquet
			
		}catch(Exception e){
			e.printStackTrace();
		}
		

	}

}
