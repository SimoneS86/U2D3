package Simone.menuapp.entities.toppings;

import Simone.menuapp.entities.Consummation;

public class OnionTopping extends ToppingDecorator {

	public OnionTopping(Consummation c) {
		super(c);
		this.name = "Cipolla";
		this.price = 1.00;
		this.calories = 100;
	}
}
