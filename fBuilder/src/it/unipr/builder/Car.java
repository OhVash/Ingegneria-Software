package it.unipr.builder;


public class Car {
	private final int id;
	private final String brand;
	private final String model;
	private final String color;
	private final String gear;
	
	Car(int id, String brand, String model, String color, String gear) {
		this.id=id;
		this.brand = brand;
		this.model=model;
		this.color=color;
		this.gear=gear;
	}
	
	public void printSpecs() {
		System.out.println(this.id + ", " + this.brand + ", " + this.model + ", "
							+ this.color + ", " + this.gear);
	}
}
