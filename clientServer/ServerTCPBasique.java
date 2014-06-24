package clientServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import clientServer.factory.ConnectionFactory.Protocol;

public class ServerTCPBasique {
	
	public static void main(String[] a){
		
		try{
			
			ServerSocket listennerSocket = new ServerSocket(6789);	// ouverture port 6789
			
			Socket dialogSocket = listennerSocket.accept();	// attente connection client
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(dialogSocket.getInputStream()));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(dialogSocket.getOutputStream()));
			
			// boucle de réception et d'envoi de messages
			while(true){
				String line = reader.readLine();	// réception message du client
				System.out.println("serveur recoit : " + line);
				writer.write(line);					// envoi réponse au client
				writer.newLine();					// envoi fin de chaine
				writer.flush();						// vide la mémoire tampon (force l'envoi)
			}
	       
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
