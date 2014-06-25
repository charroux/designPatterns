package log;

import java.util.Iterator;

import log.observer.LoggerObserver;


public class MainLogger {

	public static void main(String[] args) {
		
		try{
			
			LoggerObserver observer = new LoggerObserver();	// cr�ation d'un observer
			
			// transmet l'observer � l'observable (ConnectionAdaptateur h�rite de Observable)
			Logger logger = new ConnectionAdaptateur(observer);	
			
			logger.log("message 1", "localhost", 6789);
			logger.log("message 2", "localhost", 6789);
			
			// utiliser le pattern iterator pour afficher tous les messages logg�s
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
