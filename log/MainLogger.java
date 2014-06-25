package log;

import java.util.Iterator;

import log.observer.LoggerObserver;


public class MainLogger {

	public static void main(String[] args) {
		
		try{
			
			LoggerObserver observer = new LoggerObserver();	// création d'un observer
			
			// transmet l'observer à l'observable (ConnectionAdaptateur hérite de Observable)
			Logger logger = new ConnectionAdaptateur(observer);	
			
			logger.log("message 1", "localhost", 6789);
			logger.log("message 2", "localhost", 6789);
			
			// utiliser le pattern iterator pour afficher tous les messages loggés
			Iterator<String> iterator = observer.iterator();
			while(iterator.hasNext()){
				String message = iterator.next();
				System.out.println("message de l'iterateur : " + message);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		

	}

}
