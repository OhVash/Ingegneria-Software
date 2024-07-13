package it.unipr.singleton;

public class Singleton {
	private static volatile Singleton instance;
	private String data;
	
	private Singleton (String data) { //costruttore privato
		this.data = data;
	}
	
	public static Singleton getInstance(String data) { //metodo pubblico per richiedere istanza
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton(data);
				}
			}
		}
		return instance;
	}
}
