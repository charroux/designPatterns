package serveur;

/**
 * Fermeture automatique de la connection
 * @author Charroux_std
 *
 */
public interface ServerBasique {
	
	public void ouvrirConnection(int port) throws Exception;
	
	public boolean envoyer(String message);
	
	public String recevoir() throws Exception;
	
}
