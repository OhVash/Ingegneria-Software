package it.unipr.ingsw.concurrency.esame090224;

public class Logger {
	private static volatile Logger instance;
	
	public Logger() {
		
	}
	
	public static synchronized Logger getInstance() {
		if (instance==null) {
			instance = new Logger();
		}
		return instance;
	}
	
	public void log(String message) {
		System.out.println(message);
	}
}
