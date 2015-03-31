package serveur;

import java.util.ArrayList;
import java.util.List;

public class Observable {
	
	List<Observer> observers = new ArrayList<Observer>();
	
	public void attach(Observer observer){
		if(observers.contains(observer) == false){
			observers.add(observer);
		}
	}
	
	public void detach(Observer observer){
		observers.remove(observer);
	}
	
	/**
	 * Broadcast le message à tous les observers : 
	 * appeler la méthode appelée change des observers
	 * @param message
	 */
	public void notify(String message){	
		for(Observer observer : observers){
			observer.change(message, this);
		}
	}
}
