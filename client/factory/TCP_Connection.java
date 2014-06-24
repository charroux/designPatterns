package client.factory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class TCP_Connection implements Connection{

	Socket socket;
	BufferedReader reader;
	BufferedWriter writer; 
	
	public TCP_Connection(String host, int port) throws Exception {
		socket = new Socket(host, port); 
		reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
	}

	@Override
	public void send(String message) throws Exception {
		writer.write(message);
		writer.newLine();
		writer.flush();
	}

	@Override
	public String receive() throws Exception {
		String message = reader.readLine();
		return message;
	}

	
}
