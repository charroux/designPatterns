package clientServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {
	
	public static void main(String[] a){
		
		try{
			
			ServerSocket listennerSocket = new ServerSocket(6789);
			
			Socket dialogSocket = listennerSocket.accept();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(dialogSocket.getInputStream()));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(dialogSocket.getOutputStream()));
			
			while(true){
				String line = reader.readLine();
				System.out.println("serveur recoit : " + line);
				writer.write(line);
				writer.newLine();
				writer.flush();
			}
	       
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
