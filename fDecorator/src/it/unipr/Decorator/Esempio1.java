package it.unipr.Decorator;

public class Esempio1 {
	public void go() {
		//notifier base
		Notifier notifier = new BasicNotifier();
		
		//lo  decoro con i vari decorator.
		notifier = new WhatsappNotifier(notifier);
		notifier = new FacebookNotifier(notifier);
		notifier = new EmailNotifier(notifier);
		
		notifier.send(" New Opening!");
		
		Notifier notifier2 = new BasicNotifier();
		notifier2 = new WhatsappNotifier(notifier2);
		
		notifier2.send("Only Basic and WhatsApp");
	}
	
	public static void main(String[] args) {
		new Esempio1().go();
	}

}
