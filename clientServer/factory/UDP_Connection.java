package clientServer.factory;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import clientServer.singleton.SingletonUDPConnection;

public class UDP_Connection implements Connection{

	InetAddress adresseClient;
	int port;
	
	@Override
	public void connection(int port) throws Exception {
		DatagramSocket serverSocket = SingletonUDPConnection.getServerSocket();
	}

	@Override
	public void send(String message) throws Exception {
		String reponse = new String("reponse");	// prépare réponse
		byte[] bytes = reponse.getBytes();		// convertir réponse en byte[]
		// prépare le paquet
		DatagramPacket sendPacket = new DatagramPacket(bytes, bytes.length, adresseClient, port);
		DatagramSocket serverSocket = SingletonUDPConnection.getServerSocket();
		serverSocket.send(sendPacket);			// envoi paquet
	}

	@Override
	public String receive() throws Exception {
		DatagramSocket serverSocket = SingletonUDPConnection.getServerSocket();
		byte[] receiveData = new byte[1024];	// tableau pour recevoir données
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		serverSocket.receive(receivePacket);	// attente message
		adresseClient = receivePacket.getAddress(); // get adresse client
		port = receivePacket.getPort(); // get port client
		String message = new String(receiveData);	// conversion bytes en String
		return message;
	}


}
