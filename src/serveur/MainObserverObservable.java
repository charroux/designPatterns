package serveur;

public class MainObserverObservable {

	public static void main(String[] args) {
		Observable observable = new Observable();
		Observer observer1 = new Observer();
		Observer observer2 = new Observer();
		observable.attach(observer1);
		observable.attach(observer2);
		observable.notify("coucou");
	}

}
