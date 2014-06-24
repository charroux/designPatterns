package clientServer.factory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import clientServer.singleton.SingletonTCPConnection;

public class TCP_Connection  implements Connection{

	Socket dialogSocket;
	
	@Override
	public void connection(int port) throws Exception {
		ServerSocket listennerSocket = SingletonTCPConnection.getListennerSocket();
		dialogSocket = listennerSocket.accept();	// attente connection client
	}

	@Override
	public void send(String message) throws Exception {
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(dialogSocket.getOutputStream()));
		writer.write(message);					// envoi réponse au client
		writer.newLine();					// envoi fin de chaine
		writer.flush();						// vide la mémoire tampon (force l'envoi)
	}

	@Override
	public String receive() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(dialogSocket.getInputStream()));	
		String message = reader.readLine();	// réception message du client
		return message;
	}


}
