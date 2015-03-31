package serveur;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;


public class ServerUDPBasique implements ServerBasique{

	private DatagramSocket serverSocket;
	private byte[] receiveData = new byte[1024];	// tableau pour recevoir données
	private InetAddress adresseClient;
	private int port;
	
	List<Observer> observers = new ArrayList<Observer>();
	
	public void attach(Observer observer){
		if(observers.contains(observer) == false){
			observers.add(observer);
		}
	}
	
	public void detach(Observer observer){
		observers.remove(observer);
	}
	
	/**
	 * Broadcast le message à tous les observers : 
	 * appeler la méthode appelée change des observers
	 * @param message
	 */
	public void notify(String message){	
		for(Observer observer : observers){
			observer.change(message, this);
		}
	}

	@Override
	public void ouvrirConnection(int port) throws Exception{ 
		serverSocket = SingletonUDP.getServer(port); 
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
		this.notify(message);				// notifications aux observers
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
