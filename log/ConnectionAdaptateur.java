package log;

import java.util.Observable;

import log.observer.LoggerObserver;

import client.factory.Connection;
import client.factory.ConnectionFactory;
import client.factory.ConnectionFactory.Protocol;

/**
 * Implémente Logger et Connection pour réaliser le pattern Adaptateur.
 * Hérite de Observable pour que les changements dans cette classe soient
 * répercupés vers les Observers (pattern observer). 
 * @author charroux
 *
 */
public class ConnectionAdaptateur extends Observable implements Logger, Connection{

	Connection connection;
	
	public ConnectionAdaptateur(LoggerObserver observer){
		this.addObserver(observer);						// enregistrement de l'observer
	}
	
	@Override
	public void send(String message) throws Exception {
		connection.send(message);
	}

	@Override
	public void log(String message, String host, int port) throws Exception {
		ConnectionFactory connectionFactory = new ConnectionFactory(); // Connection au serveur
		connection = connectionFactory.getConnexion(Protocol.UDP, host, port);		
		this.send(message); // Utilisation du send pour envoyer le message au serveur
		this.setChanged();
		this.notifyObservers(message);	// prévient l'observer des changements (voir la méthode update de log.observer.LoggerObserver
	}

	@Override
	public String receive() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
