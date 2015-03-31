package serveur;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerTCPBasique implements ServerBasique {
	
	private BufferedReader reader;
	private BufferedWriter writer;

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
	public void ouvrirConnection(int port) throws Exception {
		ServerSocket serverSocket = SingletonTCP.getServer(port);
		Socket dialogSocket = serverSocket.accept();	// attente connection client
		reader = new BufferedReader(new InputStreamReader(dialogSocket.getInputStream()));
		writer = new BufferedWriter(new OutputStreamWriter(dialogSocket.getOutputStream()));
	}

	@Override
	public void envoyer(String message) throws Exception {
		writer.write(message);				// envoi réponse au client
		writer.newLine();					// envoi fin de chaine
		writer.flush();	
	}

	@Override
	public String recevoir() throws Exception {
		String message = reader.readLine();	// réception message du client
		this.notify(message);				// notifications aux observers
		return message;		
	}



}
