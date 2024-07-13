package it.unipr.composite;
// tutte le classi componenti possono estendere altri componenti
public class Circle extends Dot {
	private int radius;
	
	public Circle (int x, int y, int radius) {
		super(x, y);
		this.radius = radius;
	}
	
	@Override
	public void draw() {
		System.out.println("Draw a circle at (" + x + ", " + y + ", with radius: " + radius);
	}

}
