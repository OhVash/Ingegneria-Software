package it.unipr.informatica.concurrent.locks;

public interface Lock {
	public void lock() throws InterruptedException;
	
	public void unlock();
	
	public Condition newCondition();

}
