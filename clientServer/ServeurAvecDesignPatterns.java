package clientServer;

import clientServer.factory.Connection;
import clientServer.factory.ConnectionFactory;
import clientServer.factory.TCP_Connection;
import clientServer.factory.ConnectionFactory.Protocol;

public class ServeurAvecDesignPatterns {

	
	public static void main(String[] args) {
		
		// utilisation du pattern factory qui masque entièrement la classe UDP_Connection
		try{
			ConnectionFactory factory = new ConnectionFactory();
			Connection connection = factory.getConnection(Protocol.UDP);
			connection.connection(9999);
			while(true){
				String message = connection.receive();
				connection.send(message);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		try{
			
			// Connection connection1 = new Connection(); impossible d'instancier une interface
			Connection connection = new TCP_Connection();
			connection.connection(6666);
			while(true){
				String message = connection.receive();
				connection.send(message);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		/*try{		// utilisation du polymorphisme quand connection pointe vers UDP_Connection
			Connection connection = new UDP_Connection();
			connection.connection(9999);
			while(true){
				String message = connection.receive();
				connection.send(message);
			}
		}catch(Exception e){
			e.printStackTrace();
		}*/
		
	}

}
