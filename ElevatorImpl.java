package it.unipr.ingsw.concurrency.esame220623;

public class ElevatorImpl implements Elevator {
	final int soglia = 10;
	private int worker_inside;
	private Object mutex;
	
	public ElevatorImpl() {
		this.worker_inside =0;
		mutex = new Object();
	}

	@Override
	public void getIn() {
		synchronized (mutex) {
			while(worker_inside>=soglia) {
				try {
					mutex.wait();
				} catch (Exception e) {
					Thread.currentThread().interrupt();
				}	
			}
			
			worker_inside++;
			System.out.println(Thread.currentThread().getName() + "vuole entrare");
			
			if(worker_inside == soglia) {
				mutex.notifyAll();
			} else if (worker_inside<soglia) {
				try {
					mutex.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		
			
		}
		
	}

	@Override
	public void getOut() {
		synchronized (mutex) {
			while (worker_inside==0) {
				try {
					mutex.wait();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
			worker_inside--;
			System.out.println(Thread.currentThread().getName() + "uscito");
			if (worker_inside==0) {
				mutex.notifyAll();
			}
			
		}
		
		
	}

}
