package it.unipr.builder;

public class CarBuilder {
	private int id;
	private String brand;
	private String model;
	private String color;
	private String gear;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setGear(String gear) {
		this.gear = gear;
	}
	
	public void clearAll() {
		this.id=0;
		this.brand=null;
		this.model=null;
		this.color=null;
		this.gear=null;
	}
	
	public Car build() {
		return new Car(id, brand,model,color,gear);
	}

}
