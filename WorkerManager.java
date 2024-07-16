package it.unipr.ingsw.concurrency.esame220623;

import java.util.ArrayList;
import java.util.List;

public class WorkerManager {
	private static volatile WorkerManager instance;
	private final Elevator elevator;
	private final List<Worker> workers;
	
	private WorkerManager() {
		this.elevator = new ElevatorImpl();
		this.workers = new ArrayList<Worker>();
		for (int i=0; i<50; i++) {
			this.workers.add(new WorkerImpl(elevator));
		}
	}
	
	public static synchronized WorkerManager getInstance() {
		if(instance==null) {
			instance = new WorkerManager();
		}
		return instance;
	}
	
	public List<Worker> getWorkers(){
		return workers;
	}

}
