package serveur;

public class Main {

	public static void main(String[] args) {
		try{
			
			// sans factory UDP
			ServerBasique serveurUDP = new ServerUDPBasique();
			serveurUDP.ouvrirConnection(8869);
			String message1 = serveurUDP.recevoir();
			serveurUDP.envoyer("Reponse");
			
			// sans factory TCP
			ServerBasique serveurTCP = new ServerTCPBasique();
			serveurTCP.ouvrirConnection(8895);
			String message2 = serveurTCP.recevoir();
			serveurTCP.envoyer("Reponse");
			
		}catch(Exception e){
			e.printStackTrace();
		}
				

	}

}
