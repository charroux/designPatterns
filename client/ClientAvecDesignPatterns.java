package client;

import client.factory.Connection;
import client.factory.ConnectionFactory;
import client.factory.ConnectionFactory.Protocol;

public class ClientAvecDesignPatterns {
	
	public static void main(String[] args) {

		try{
			ConnectionFactory connectionFactory = new ConnectionFactory();
			Connection connection = connectionFactory.getConnexion(Protocol.UDP, "localhost", 6789);
			connection.send("Salut");
			String message = connection.receive();
			System.out.println(message);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
