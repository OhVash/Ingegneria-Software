package it.unipr.informatica.concurrent;
public interface BlockingQueue<T> {
	
	public void put(T e) throws InterruptedException; //aggiunge elemento
	
	public T take() throws InterruptedException; //rimuove testa
	
	public int remainingCapacity(); //verifica capacità rimasta della coda
	
	public boolean isEmpty(); //verifica coda vuota
	
	public void clear(); //rimuove tutti gli elementi

	void printQueue();
}