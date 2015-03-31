package serveur;

public class Main {

	public static void main(String[] args) {
		try{
			
			Observer observer1 = new Observer();
			Observer observer2 = new Observer();
			
			Factory factory = new Factory();
			ServerBasique serveur = factory.getServeur(TypeServer.UDP);
			
			serveur.attach(observer1);
			serveur.attach(observer2);
			
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
