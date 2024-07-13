package it.unipr.factorymethod;

public class Esempio1 {
	private void go() {
		Restaurant beefRestaurant = new BeefBurgerRestaurant();
		System.out.println("A client ordered a Beef Burger!");
		Burger beefBurger = beefRestaurant.orderBurger();
		Restaurant veggieRestaurant = new VeggieBurgerRestaurant();
		System.out.println("A client ordered a Veggie Burger!");
		Burger veggieBurger = veggieRestaurant.orderBurger();
	}

	public static void main (String[] args) {
		new Esempio1().go();
	}
}