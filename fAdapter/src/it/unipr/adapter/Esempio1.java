package it.unipr.adapter;

public class Esempio1 {
	
	public void go() {
		Buco buco = new Buco(3);
		Cilindro cil = new Cilindro(2);
		
		System.out.println("Il cilindro di raggio 2cm ci sta nel buco di raggio 3cm?");
		if (buco.fits(cil)) {
			System.out.println("Si");
		} else {
			System.out.println("No");
		}
		
		Parallelepipedo par = new Parallelepipedo(4);
		Parallelepipedo par2 = new Parallelepipedo(5);
		/* System.out.println("Il parallelepipedo largo 3cm ci sta nel buco di raggio 3cm?");
		if (buco.fits(par)) {
			System.out.println("Si");
		} else {
			System.out.println("No");
		} //va in crash perchè il formato non è compatibile, qui entra in gioco la classe adapter.
		*/
		
		Adapter piccoloPar = new Adapter(par);
		Adapter grandePar = new Adapter(par2);
		
		System.out.println("Il parallelepipedo largo 3cm ci sta nel buco di raggio 3cm?");
		if (buco.fits(piccoloPar)) {
			System.out.println("Si");
		} else {
			System.out.println("No");
		}
		
		System.out.println("Il parallelepipedo largo 4 cm ci sta nel buco di raggio 3cm?");
		if (buco.fits(grandePar)) {
			System.out.println("Si");
		} else {
			System.out.println("No");
		}
	}
	
	public static void main (String[] args) {
		new Esempio1().go();
	}

}
