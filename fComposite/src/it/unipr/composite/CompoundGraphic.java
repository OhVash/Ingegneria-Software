package it.unipr.composite;

import java.util.ArrayList;
import java.util.List;

/* la classe composite rappresenta componenti complessi che possono avere figli.
 * solitamente delegano il lavoro ai figli e poi sommano i risultati.
 */

public class CompoundGraphic implements Graphic {
	private List<Graphic> children = new ArrayList<>();
	
	public void add(Graphic child) {
		children.add(child);
	}
	
	public void remove(Graphic child) {
		children.remove(child);
	}

	@Override
	public void move(int x, int y) {
		for (Graphic child: children) {
			child.move(x, y);
		}	
	}
	
/* un oggetto composito esegue la sua logica primaria in un modo particolare, attraversa ricorsivamente
 * tutti i figli, collezionando e sommando i risultati.
 */
	@Override
	public void draw() {
		System.out.println("Drawing a compound graphic");
		for (Graphic childGraphic : children) {
			childGraphic.draw();
		}
		
	}

} 
