package clientServer;

public class MainServeur {

	
	public static void main(String[] args) {
		try{
			Connection connection = new TCP_Connection();
			connection.connection(6666);
			while(true){
				String message = connection.receive();
				connection.send(message);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		/*try{
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
