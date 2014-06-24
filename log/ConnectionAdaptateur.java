package log;

import client.factory.Connection;
import client.factory.ConnectionFactory;
import client.factory.ConnectionFactory.Protocol;

public class ConnectionAdaptateur implements Logger, Connection{

	Connection connection;
	
	@Override
	public void send(String message) throws Exception {
		connection.send(message);
	}

	@Override
	public void log(String message, String host, int port) throws Exception {
		ConnectionFactory connectionFactory = new ConnectionFactory(); // Connection au serveur
		connection = connectionFactory.getConnexion(Protocol.UDP, host, port);		
		this.send(message); // Utilisation du send pour envoyer le message au serveur
	}

	@Override
	public String receive() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
