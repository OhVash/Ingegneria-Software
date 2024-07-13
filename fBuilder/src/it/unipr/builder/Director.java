package it.unipr.builder;

public class Director {
	public void buildManualSkodaFabia(CarBuilder builder) {
		builder.clearAll();
		builder.setBrand("Skoda");
		builder.setModel("Fabia");
		builder.setGear("Manual");
	}
	
	public void buildLamborghiniAventador(CarBuilder builder) {
		builder.clearAll();
		builder.setBrand("Lamborghini");
		builder.setModel("Aventador");
		builder.setGear("Automatic");
	}

}
