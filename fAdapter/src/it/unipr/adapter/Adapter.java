package it.unipr.adapter;

public class Adapter extends Cilindro {
	private Parallelepipedo par;

	public Adapter(Parallelepipedo par) {
		super(0);
		this.par = par;
	}
	
	@Override
	public double getRaggio() {
		return (par.getLarghezza()*Math.sqrt(2))/2;
	}

}
