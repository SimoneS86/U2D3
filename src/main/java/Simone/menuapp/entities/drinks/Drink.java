package Simone.menuapp.entities.drinks;

import Simone.menuapp.entities.Consummation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public abstract class Drink extends Consummation {
	double size;

	public String toString() {
		return this.getName() + " " + this.getSize() + ", prezzo: " + this.getPrice() + "€, calorie:"
				+ this.getCalories();
	}
}
