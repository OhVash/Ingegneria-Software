package it.unipr.esame24062024;

import java.util.Random;

public class JobImpl implements Job {
	private int max_attesa = 200; //200ms
	private int min_attesa = 100; //200ms
	@Override
	public void perform() {
		
		Random random = new Random();
		int attesa = 100+ random.nextInt((max_attesa-min_attesa) + 1);
		
		try {
			Thread.sleep(attesa);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("[PERFORM] Job eseguito da " + Thread.currentThread().getName() + " che ha atteso " + attesa + " ms");
		
	}

}
