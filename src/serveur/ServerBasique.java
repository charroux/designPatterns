package serveur;

/**
 * Fermeture automatique de la connection
 * 
 * @author Charroux_std
 *
 */
public interface ServerBasique {
	
	public void ouvrirConnection(int port) throws Exception;
	
	public void envoyer(String message) throws Exception;
	
	public String recevoir() throws Exception;
	
}
