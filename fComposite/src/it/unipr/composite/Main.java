package it.unipr.composite;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main (String[] args) {
		ImageEditor editor = new ImageEditor();
		editor.load();
		editor.draw();
		List<Graphic> selectedComponents = new ArrayList<>();
		selectedComponents.add(new Dot(7, 8));
		selectedComponents.add(new Circle(10, 20, 15));
		editor.groupSelected(selectedComponents);
		editor.draw();
	}
}