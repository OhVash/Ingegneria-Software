package it.unipr.adapter;

public class Buco {
	private double raggio;
	
	public Buco(double raggio ) {
		this.raggio = raggio;
	}
	
	public double getRaggio() {
		return raggio;
	}
	
	public boolean fits(Cilindro cil) {
		return this.getRaggio()>= cil.getRaggio();
	}

}
