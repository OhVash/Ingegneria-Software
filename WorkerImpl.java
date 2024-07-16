package it.unipr.ingsw.concurrency.esame220623;

import java.util.Random;

public class WorkerImpl implements Worker {
	private final Elevator elevator;
	
	public WorkerImpl(Elevator elevator) {
		this.elevator = elevator;
	}
	@Override
	public void execute() {
		try {
			elevator.getIn();
			System.out.println(Thread.currentThread().getName() + "entrato in ascensore");
			Thread.sleep(new Random().nextInt(151)+100);
			elevator.getOut();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Elevator getElevator() {
		// TODO Auto-generated method stub
		return elevator;
	}

}
