package clientServer;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDP_Connection implements Connection{

	InetAddress adresseClient;
	int port;
	
	@Override
	public void connection(int port) throws Exception {
		DatagramSocket serverSocket = SingletonUDPConnection.getServerSocket();
	}

	@Override
	public void send(String message) throws Exception {
		
		
		String reponse = new String("reponse");	// pr�pare r�ponse
		byte[] bytes = reponse.getBytes();		// convertir r�ponse en byte[]
		// pr�pare le paquet
		DatagramPacket sendPacket = new DatagramPacket(bytes, bytes.length, adresseClient, port);
		DatagramSocket serverSocket = SingletonUDPConnection.getServerSocket();
		serverSocket.send(sendPacket);			// envoi paquet
		
	}

	@Override
	public String receive() throws Exception {
		DatagramSocket serverSocket = SingletonUDPConnection.getServerSocket();
		byte[] receiveData = new byte[1024];	// tableau pour recevoir donn�es
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		serverSocket.receive(receivePacket);	// attente message
		adresseClient = receivePacket.getAddress(); // get adresse client
		port = receivePacket.getPort(); // get port client
		String message = new String(receiveData);	// conversion bytes en String
		return message;
	}


}
