package it.unipr.composite;

/* la classe leaf rappresenta gli oggetti finali di una composizione, una foglia non può
 * avere sotto oggetti. solitamente sono gli oggetti leaf a svolgere il lavoro.
 * mentre gli oggetti compositi solitamente delegano alle loro foglie.
 */
public class Dot implements Graphic{
	protected int x,y;
	public Dot (int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public void move(int x, int y) {
		this.x += x;
		this.y += y;
		
	}
	@Override
	public void draw() {
		System.out.println("Draw a dot at (" + x + ", " + y + ")");
	}
	
}
