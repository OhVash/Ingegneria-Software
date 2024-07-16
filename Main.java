package it.unipr.ingsw.concurrency.esame090224;

public class Main {
	public static void main(String[] args) {
		final int W =10;
		Thread[] workers = new Thread[W]; //creo array di thread
		
		for (int i=0; i<W; i++) {
			workers[i] = new Thread(new Worker(i)); //creo thread passando il runnable worker
			workers[i].start();
		}
		
		for (int i=0; i<W; i++) {
			try {
				workers[i].join();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
