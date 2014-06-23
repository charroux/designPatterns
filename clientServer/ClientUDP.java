package clientServer;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketAddress;

public class ClientUDP {

	
	public static void main(String[] args) {
		
		try{
		
			DatagramSocket clientSocket = new DatagramSocket();
			
			String message = new String("message du client");	// message pour le serveur
			byte[] bytes = message.getBytes();	// convertion en byte[]
			// cherche adresse serveur
			InetAddress adresseServeur = InetAddress.getByName("localhost");	
			DatagramPacket sendPacket =  			// prépare le paquet
					new DatagramPacket(bytes, bytes.length, adresseServeur, 9876);
			clientSocket.send(sendPacket );	// envoi paquet
			
			byte[] receiveData = new byte[1024];	// tableau pour recevoir données
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			clientSocket.receive(receivePacket);	// attente message
			message = new String(receiveData);	// conversion bytes en String
			System.out.println(message);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		

	}

}
