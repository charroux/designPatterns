package clientServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientTCP {

	public static void main(String[] args) {

		try{
		
			// connection au server localhost sur le port 6789
			Socket socket = new Socket("localhost", 6789); 
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			writer.write("Salut !");	// envoi du message "salut !" au serveur
			writer.newLine();			// fin du message
			writer.flush();				// force l'envoi (vide mémoire tampon)
			
			String response = reader.readLine();	// attente réponse du serveur
			System.out.println("Client recoit = " + response);

		}catch(Exception e){
			e.printStackTrace();
		}
		

	}

}
