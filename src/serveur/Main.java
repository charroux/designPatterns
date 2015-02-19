package serveur;

public class Main {

	public static void main(String[] args) {
		try{
			
			// sans factory
			ServerBasique serveur = new ServerUDPBasique();
			serveur.ouvrirConnection(8869);
			String message = serveur.recevoir();
			serveur.envoyer("Reponse");
			
		}catch(Exception e){
			e.printStackTrace();
		}
				

	}

}
