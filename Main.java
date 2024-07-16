package it.unipr.ingsw.concurrency.esame220623;

import java.util.List;

public class Main {
 public static void main(String[] args) {
	WorkerManager manager = WorkerManager.getInstance();
	List<Worker> workers = manager.getWorkers();
	
	for (Worker worker : workers) {
		Thread thread = new Thread(()->{
			worker.execute();
			System.out.println(Thread.currentThread().getName() + "Done!");
		});
		thread.start();
				
	}
}
}
