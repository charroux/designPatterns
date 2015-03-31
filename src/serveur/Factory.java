package serveur;

public class Factory {
	
	public ServerBasique getServeur(TypeServer typeServer){
		if(typeServer == TypeServer.TCP){
			ServerTCPBasique tcp = new ServerTCPBasique();
			return tcp;
		} else {
			ServerUDPBasique udp = new ServerUDPBasique();
			return udp;
		}	
	}


}
