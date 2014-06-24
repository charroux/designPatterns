package client.factory;


public class ConnectionFactory {
	
	public enum Protocol{
		UDP,
		TCP
	}
	
	public Connection getConnexion(Protocol protocol, String host, int port) throws Exception{
		if(protocol == Protocol.UDP){
			return new UDP_Connection(host, port);
		} else if(protocol == Protocol.TCP){
			return new TCP_Connection(host, port);
		} else {
			return null;
		}
	}

}
