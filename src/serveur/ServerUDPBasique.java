package serveur;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class ServerUDPBasique implements ServerBasique{

	private DatagramSocket serverSocket;
	private byte[] receiveData = new byte[1024];	// tableau pour recevoir données
	private InetAddress adresseClient;
	private int port;

	@Override
	public void ouvrirConnection(int port) throws Exception{ 
		serverSocket = Singleton.getServer(port); 
	}

	@Override
	public void envoyer(String message) throws Exception{
		byte[] bytes = message.getBytes();		// convertir réponse en byte[]
		DatagramPacket sendPacket = 			// prépare le paquet
				new DatagramPacket(bytes, bytes.length, adresseClient, port);
		
		serverSocket.send(sendPacket);			// envoi paquet
	}

	@Override
	public String recevoir() throws Exception{
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		serverSocket.receive(receivePacket);	// attente message
		String message = new String(receiveData);	// conversion bytes en String
		adresseClient = receivePacket.getAddress(); // get adresse client
		port = receivePacket.getPort(); // get port client
		return message;
	}
	
	protected void finalize() throws Throwable{
		if(serverSocket != null){
			serverSocket.close();
		}
	}

}
