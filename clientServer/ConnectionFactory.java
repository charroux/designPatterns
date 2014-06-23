package clientServer;

public class ConnectionFactory {
	 
	public enum Protocol{
		UDP,
		TCP
	}
	
	public ? getConnection(String adresse, Protocol protocol){
		if(protocol == Protocol.TCP){
			// créer un serveur TCP
			return ...
		} else {
			// créer un serveur UDP
			return ...
		}
	}

}
