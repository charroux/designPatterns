package log;


public class MainLogger {

	public static void main(String[] args) {
		
		try{
			Logger logger = new ConnectionAdaptateur();
			logger.log("Salut", "localhost", 6789);
		}catch(Exception e){
			e.printStackTrace();
		}
		

	}

}
