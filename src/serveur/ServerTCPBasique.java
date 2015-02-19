package serveur;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCPBasique implements ServerBasique{
	
	private BufferedReader reader;
	private BufferedWriter writer;

	@Override
	public void ouvrirConnection(int port) throws Exception {
		ServerSocket serverSocket = SingletonTCP.getServer(port);
		Socket dialogSocket = serverSocket.accept();	// attente connection client
		reader = new BufferedReader(new InputStreamReader(dialogSocket.getInputStream()));
		writer = new BufferedWriter(new OutputStreamWriter(dialogSocket.getOutputStream()));
	}

	@Override
	public void envoyer(String message) throws Exception {
		writer.write(message);				// envoi réponse au client
		writer.newLine();					// envoi fin de chaine
		writer.flush();	
	}

	@Override
	public String recevoir() throws Exception {
		return reader.readLine();	// réception message du client
	}



}
