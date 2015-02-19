package serveur;

public class Factory {
	
	public ServerBasique getServeur(boolean choixTcp){
		if(choixTcp){
			ServerTCPBasique tcp = new ServerTCPBasique();
			return tcp;
		} else {
			ServerUDPBasique udp = new ServerUDPBasique();
			return udp;
		}	
	}
	
	public static void main(String[] a){
		Factory factory = new Factory();
		ServerBasique serveur = factory.getServeur(true);
		
	}

}
