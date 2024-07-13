package it.unipr.prototype;

public class Rectangle extends Shape {
	int width;
	int height;
	
	public Rectangle () {
		
	}
	
	public Rectangle (Rectangle source) {
		super(source);
		this.width = source.width;
		this.height = source.height;
	}

	@Override
	public Shape clone() {
		return new Rectangle(this);
	}
	
	@Override	
	public String toString() {
		return super.toString() +"[width= " + width + ", height= " + height + "]";
		
	}
}
