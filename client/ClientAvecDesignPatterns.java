package client;

import client.factory.Connection;
import client.factory.ConnectionFactory;
import client.factory.ConnectionFactory.Protocol;

public class ClientAvecDesignPatterns {
	
	public static void main(String[] args) {

		try{
			ConnectionFactory connectionFactory = new ConnectionFactory();
			Connection connection = connectionFactory.getConnexion(Protocol.UDP, "localhost", 6666);
			connection.send("Salut");
			String message = connection.receive();
			System.out.println("message renvoye par le serveur : " + message);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
