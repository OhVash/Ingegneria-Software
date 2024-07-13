package it.unipr.prototype;

public class Circle extends Shape {
	int radius;
	
	public Circle() {
		
	}
	
	public Circle (Circle source) {
		super(source);
		this.radius = source.radius;
	}

	@Override
	public Shape clone() {
		return new Circle(this);
	}
	
	@Override	
	public String toString() {
		return super.toString() +"[radius= " + radius + "]";
		
	}
	

}
