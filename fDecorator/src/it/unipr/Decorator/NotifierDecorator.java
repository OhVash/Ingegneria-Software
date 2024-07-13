package it.unipr.Decorator;
//la classe base decorator segue la stessa interfaccia degli altri.
//lo scopo di questa classe è definire l'interfaccia di wrapping per i vari decorators.

public abstract class NotifierDecorator implements Notifier {
	protected Notifier wrappedNotifier;
	
	public NotifierDecorator(Notifier notifier) {
		this.wrappedNotifier = notifier;
	}
	
	@Override
	public void send(String message) {
		wrappedNotifier.send(message);
	}
		
	
}
