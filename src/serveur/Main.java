package serveur;

public class Main {

	public static void main(String[] args) {
		try{
			
			Factory factory = new Factory();
			ServerBasique serveur = factory.getServeur(TypeServer.TCP);
			serveur.ouvrirConnection(8869);
			String message1 = serveur.recevoir();
			System.out.println("recu " + message1);
			serveur.envoyer("Reponse");
			
/*			// sans factory UDP
			ServerBasique serveurUDP = new ServerUDPBasique();
			serveurUDP.ouvrirConnection(8869);
			String message1 = serveurUDP.recevoir();
			System.out.println("recu " + message1);
			serveurUDP.envoyer("Reponse");
			
			// sans factory TCP
			ServerBasique serveurTCP = new ServerTCPBasique();
			serveurTCP.ouvrirConnection(8895);
			String message2 = serveurTCP.recevoir();
			System.out.println("recu " + message2);
			serveurTCP.envoyer("Reponse");*/
			
		}catch(Exception e){
			e.printStackTrace();
		}
				

	}

}
