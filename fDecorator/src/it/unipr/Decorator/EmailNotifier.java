package it.unipr.Decorator;

public class EmailNotifier extends NotifierDecorator {

	public EmailNotifier(Notifier notifier) {
		super(notifier);
	}
	
	@Override
	public void send(String message) {
		super.send(message);
		sendMail(message);
	}
	
	public void sendMail(String message) {
		System.out.println("Sending Mail Notification :" + message);
	}

}

