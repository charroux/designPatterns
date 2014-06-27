package log.observer;

import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.util.Stack;

public class LoggerObserver implements Observer{

	// conteneur pour stocker les messages (voir update)
	Stack<String> messages = new Stack<String>();	
	
	/**
	 * Méthode appelée automatiquement dès qu'un 
	 * changement se produit dans l'observable
	 */
	@Override
	public void update(Observable o, Object message) {
		messages.add((String)message);	// ajout des messages dans le conteneur
		System.out.println("Dans observer, recu de observable " + o + " le message : " + (String)message);
	}

	public Iterator<String> iterator(){
		return messages.iterator();
	}
}
