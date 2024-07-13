package it.unipr.Decorator;

public class FacebookNotifier extends NotifierDecorator {

	public FacebookNotifier(Notifier notifier) {
		super(notifier);
	}
	
	@Override
	public void send(String message) {
		super.send(message);
		sendFb(message);
	}
	
	public void sendFb(String message) {
		System.out.println("Sending Facebook Notification :" + message);
	}

}

