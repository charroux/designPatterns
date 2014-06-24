package client.factory;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UDP_Connection implements Connection{

	DatagramSocket clientSocket;
	String host;
	int port;
	
	public UDP_Connection(String host, int port) throws Exception{
		clientSocket = new DatagramSocket();
		this.host = host;
		this.port = port;
	}

	@Override
	public void send(String message) throws Exception {
		byte[] bytes = message.getBytes();	// convertion en byte[]
		// cherche adresse serveur
		InetAddress adresseServeur = InetAddress.getByName("localhost");	
		DatagramPacket sendPacket = new DatagramPacket(bytes, bytes.length, adresseServeur, 9876);
		clientSocket.send(sendPacket );	// envoi paquet
	}

	@Override
	public String receive() throws Exception {
		byte[] receiveData = new byte[1024];	// tableau pour recevoir données
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		clientSocket.receive(receivePacket);	// attente message
		String message = new String(receiveData);	// conversion bytes en String
		return message;
	}


}
