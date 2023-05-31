package Simone.menuapp.entities;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Setter
@Getter
@Slf4j
public class Menu {
	private List<Product> menuEntries = new ArrayList<>();

	public void print() {
		System.out.println();
		System.out.println("******************* MENU ****************");
		this.menuEntries.forEach(prod -> System.out.println(prod.toString()));

	}
}
