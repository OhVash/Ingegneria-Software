package it.unipr.prototype;
//prototipo base delle forme
public abstract class Shape {
	int x;
	int y;
	String color;
	
	public Shape () {
		
	}
	
	public Shape (Shape source) {
		this.x = source.x;
		this.y = source.y;
		this.color = source.color;
	}
	
	public abstract Shape clone();
	
	@Override	
	public String toString() {
		return this.getClass().getSimpleName() +"[X= " + x + ", Y= " + y + ",color= " + color + "]";
		
	}
}
