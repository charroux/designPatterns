package clientServer;

public class ConnectionFactory {
	 
	public enum Protocol{
		UDP,
		TCP
	}
	
	public ? getConnection(String adresse, Protocol protocol){
		if(protocol == Protocol.TCP){
			// cr�er un serveur TCP
			return ...
		} else {
			// cr�er un serveur UDP
			return ...
		}
	}

}
