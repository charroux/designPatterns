package serveur;

public class Observer {

	public void change(String message, Observable observable) {
		System.out.println(this + " recoie " + message + " de " + observable);
	}

}
