package it.unipr.abstractfactory;

import java.security.DomainCombiner;

public class Esempio1 {
	
	public void go() {
		AsusManufacturer asus = new AsusManufacturer();
		MsiManufacturer msi = new MsiManufacturer();
		
		System.out.println("Client number 1 ordered an asus gpu");
		Gpu gpu = asus.orderGpu();
		
		System.out.println("Client 2 ordered a msi gpu");
		System.out.println("Client 2 ordered a msi monitor");
		gpu = msi.orderGpu();
		Monitor monitor = msi.orderMonitor();
		
		System.out.println("Client 3 ordered an asus monitor");
		monitor = asus.orderMonitor();
	}
	
	public static void main (String[] args) {
		new Esempio1().go();
	}

}
