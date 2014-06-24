package client.factory;

public interface Connection{
	
	void send(String message) throws Exception;
	
	String receive() throws Exception;

}
