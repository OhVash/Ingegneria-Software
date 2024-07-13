package it.unipr.abstractfactory;

import java.util.Random;

public class MsiGpu implements Gpu {

	@Override
	public void assemble() {
		Random random = new Random();
		int x = random.nextInt(123456) +1;
		System.out.println("Producing a MSI-GPU serial: " + x);
	}

}
