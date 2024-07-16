package it.unipr.ingsw.concurrency.esame090224;

import java.util.Random;

public class ResourceImpl implements Resource {
	private final int id; //id della risorsa
	private boolean isFree; //variabile per vedere se libera o meno
	private Object mutex;
	private Logger logger = new Logger();
	
	public ResourceImpl(int id) {
		this.id = id; 
		this.isFree = true; //alla creazione è libera.
		this.mutex = new Object();
	}

	@Override
	public int getID() {
		synchronized (mutex) {
			return id;
		}
		
	}

	@Override
	public int use() {
		synchronized (mutex) {
			Random random = new Random();
			int x = random.nextInt((99+id));
			
			logger.log("random = " + x);
			return x;
		}
		
	}

	@Override
	public void release() {
		synchronized (mutex) {
			while(isFree) {
				try {
					mutex.wait();
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
			isFree = true;
			mutex.notifyAll();
		}
	}
	
	public void acquire() {
		synchronized (mutex) {
			while(!isFree) {
				try {
					mutex.wait();
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
			isFree = false;
			mutex.notifyAll();
		}
	}

}
