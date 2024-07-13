package it.unipr.Decorator;
//classe decorator concreta
class WhatsappNotifier extends NotifierDecorator {

	public WhatsappNotifier(Notifier notifier) {
		super(notifier);
	}
	
	@Override
	public void send(String message) {
		super.send(message);
		sendWhatsapp(message);
	}
	
	public void sendWhatsapp(String message) {
		System.out.println("Sending Whatsapp Notification :" + message);
	}

}
