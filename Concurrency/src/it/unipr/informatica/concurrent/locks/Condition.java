package it.unipr.informatica.concurrent.locks;

public interface Condition {
	public void await() throws InterruptedException; //non nome wait perchè non si può fare override
	
	public void signal();
	
	public void signalAll();
}
