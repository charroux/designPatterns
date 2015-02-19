package serveur;

/**
 * Fermeture automatique de la connection
 * @author Charroux_std
 *
 */
public interface ServerBasique {
	
	public boolean ouvrirConnection(int port);
	
	public boolean envoyer(String message);
	
	public String recevoir();
	
}
