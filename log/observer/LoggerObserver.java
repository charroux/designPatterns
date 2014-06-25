package log.observer;

import java.util.Observable;
import java.util.Observer;

public class LoggerObserver implements Observer{

	/**
	 * M�thode appel�e automatiquement d�s qu'un 
	 * changement se produit dans l'observable
	 */
	@Override
	public void update(Observable o, Object message) {
		System.out.println("Dans observer, recu de observable " + o + " le message : " + (String)message);
	}

}
