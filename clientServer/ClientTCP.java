package clientServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientTCP {

	public static void main(String[] args) {

		try{
		
			Socket socket = new Socket("localhost", 6789); 
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			writer.write("Salut !");
			writer.newLine();
			writer.flush();
			String response = reader.readLine();
			System.out.println("Client recoit = " + response);

		}catch(Exception e){
			e.printStackTrace();
		}
		

	}

}
