package it.unipr.Decorator;
//dichiara le operazioni comuni sia per i componenti concreti che per i decorators

public interface Notifier {
	void send(String message);
}
