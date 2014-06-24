package clientServer.factory;

public interface Connection {
	
	void connection(int port) throws Exception;
	
	void send(String message) throws Exception;
	
	String receive() throws Exception;

}
