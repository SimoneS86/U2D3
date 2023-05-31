package Simone.menuapp.entities.toppings;

import Simone.menuapp.entities.Consummation;

public class ToppingDecorator extends Consummation {

	Consummation decoratedPizza;

	public ToppingDecorator(Consummation c) {
		this.decoratedPizza = c;
	}

	public String getName() {
		return this.decoratedPizza.getName() + " più " + this.name;
	}

	public long getCalories() {
		return this.decoratedPizza.getCalories() + this.calories;
	}

	public double getPrice() {
		return this.decoratedPizza.getPrice() + this.price;
	}

	public String toString() {
		return this.getName() + ", prezzo: " + this.getPrice() + "€, calorie:" + this.getCalories();
	}

	public String toMenu() {
		return this.name + ", prezzo: " + this.price + "€, calorie:" + this.calories;
	}

}
