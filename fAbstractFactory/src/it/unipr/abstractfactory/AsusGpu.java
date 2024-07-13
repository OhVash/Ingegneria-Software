package it.unipr.abstractfactory;

import java.util.Random;

public class AsusGpu implements Gpu {

	@Override
	public void assemble() {
		Random random = new Random();
		int x = random.nextInt(123456) +1;
		System.out.println("Producing a ASUS-GPU, serial: " + x);
		
	}
	

}
