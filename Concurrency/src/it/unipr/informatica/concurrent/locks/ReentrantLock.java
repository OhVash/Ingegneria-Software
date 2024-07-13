package it.unipr.informatica.concurrent.locks;


public final class ReentrantLock implements Lock {
	private Thread owner;
	private int counter;
	private Object mutex;
	
	public ReentrantLock() {
		this.owner = null;
		this.mutex = new Object ();
		this.counter = 0;
	}

	@Override
	public void lock() throws InterruptedException{
		if (counter < 0)
			throw new IllegalMonitorStateException("counter < 0");
		
		Thread currentThread = Thread.currentThread();
		
		synchronized (mutex) {
			while (owner != null && owner != currentThread) //se il lock è occupato ma non dal thread corrente, attesa.
				try {
					mutex.wait();
				} catch (InterruptedException InterruptedException) {
					throw new IllegalMonitorStateException("Interrupted");
				}
				
			if (owner == null)  //se il lock è libero, il thread corrente diventa owner
				owner = currentThread;
			
			counter ++;
		}
	}
	
	@Override
	public void unlock() {
		synchronized (mutex) {
			
			if (owner != Thread.currentThread()) //cerchiamo di fare unlock quando non siamo owner
				throw new IllegalMonitorStateException("owner !=Thread.currentThread()");
			
			if (counter <= 0)
				throw new IllegalMonitorStateException("counter <= 0");
			
			counter --;
			
			if (counter == 0) {
				owner = null;
				mutex.notify(); //non notifyAll() perchè 
			}
		}
	}
	
	@Override
	public Condition newCondition() {
		return new InnerCondition();
	}
	
	private class InnerCondition implements Condition {
		private Object condition;
		
		private InnerCondition() {
			this.condition = new Object();
		}
		
		@Override
		public void await() throws InterruptedException {
			unlock(); //rilascia la sezione critica e si mette in attesa della condition, se va a buon fine, vuol dire che siamo gli owner del lock
			synchronized (condition) {
				condition.wait();	//esce per interruptedexception oppure se riceve una notify
			}
			lock(); //a questo punto riprendiamo in mano il lock
		}
		
		@Override
		public void signal() {
			synchronized (mutex) {
				if (owner != Thread.currentThread())
					throw new IllegalMonitorStateException("owner != Thread.currentThread()");
			}
			
			synchronized (condition) {
				condition.notify();
			}
		}
		
		@Override
		public void signalAll() {
			synchronized (mutex) {
				if (owner != Thread.currentThread())
					throw new IllegalMonitorStateException("owner != Thread.currentThread()");
			}
			
			synchronized (condition) {
				condition.notifyAll();
			}
		}
	}
}
