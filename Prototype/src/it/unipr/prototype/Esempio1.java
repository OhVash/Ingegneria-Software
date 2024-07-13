package it.unipr.prototype;

import java.util.ArrayList;
import java.util.List;

public class Esempio1 {
	List <Shape> shapes = new ArrayList<>();
	
	public Esempio1() {
		Circle circle = new Circle();
		circle.x= 10;
		circle.y= 10;
		circle.radius = 20;
		circle.color="red";
		shapes.add(circle);
		
		Circle circle2 = (Circle) circle.clone();
		shapes.add(circle2);
		
		Rectangle rectangle = new Rectangle();
		rectangle.x= 15;
		rectangle.y= 15;
		rectangle.color="blue";
		rectangle.width=10;
		rectangle.height=15;
		shapes.add(rectangle);
		
		Rectangle rectangle2 = new Rectangle();
		rectangle2.x= 11;
		rectangle2.y= 5;
		rectangle2.color="green";
		rectangle2.width=12;
		rectangle2.height=13;
		shapes.add(rectangle2);
		
		Rectangle rectangle2copy = (Rectangle) rectangle2.clone();
		shapes.add(rectangle2copy);
		
		
	}
	
	public void business_logic() {
		List<Shape> shapesCopyList = new ArrayList<>();
		// grazie a prototype possiamo clonare ogni elemento nella lisat senza sapere specificatamente a che classe appartiene
		for (Shape s: shapes) {
			shapesCopyList.add(s.clone());
		}
		
		System.out.println("Original shapes:");
		for (Shape s: shapes) {
			System.out.println(s);
		}
		
		System.out.println("\nCopied shapes:");
		for (Shape s: shapesCopyList) {
			System.out.println(s);
		}
	}
	
	public static void main (String[] args) {
		new Esempio1().business_logic();
	}

}
