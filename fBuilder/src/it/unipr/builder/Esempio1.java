package it.unipr.builder;

public class Esempio1 {
	
	public void go() {
		CarBuilder builder = new CarBuilder();
		builder.setId(1);
		builder.setBrand("Audi");
		builder.setModel("A3");
		builder.setColor("black");
		builder.setGear("manual");
		Car car1 = builder.build();
		
		car1.printSpecs();
		
		builder.setId(2);
		builder.setBrand("Bmw");
		builder.setModel("X1");
		builder.setColor("grey");
		builder.setGear("automatic");
		Car car2 = builder.build();
		car2.printSpecs();
		
		Director director = new Director();
		
		director.buildManualSkodaFabia(builder);
		builder.setId(3);
		builder.setColor("grey");
		Car car3 = builder.build();
		car3.printSpecs();
		
		director.buildLamborghiniAventador(builder);
		builder.setId(4);
		builder.setColor("Yellow");
		Car car4 = builder.build();
		car4.printSpecs();
				
	}
	
	public static void main (String[] args) {
		new Esempio1().go();
	}

}
