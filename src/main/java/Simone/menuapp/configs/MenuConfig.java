package Simone.menuapp.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import Simone.menuapp.entities.Consummation;
import Simone.menuapp.entities.Menu;
import Simone.menuapp.entities.Ordine;
import Simone.menuapp.entities.Tavolo;
import Simone.menuapp.entities.drinks.Coke;
import Simone.menuapp.entities.drinks.Lemonade;
import Simone.menuapp.entities.pizzas.Pizza;
import Simone.menuapp.entities.toppings.HamTopping;
import Simone.menuapp.entities.toppings.OnionTopping;

@Configuration
public class MenuConfig {
	@Bean
	Menu getMenu() {
		Menu menu = new Menu();

		menu.getMenuEntries().add(getMargherita());
		menu.getMenuEntries().add(getPizzaProsciutto());
		menu.getMenuEntries().add(getPizzaCipolla());
		menu.getMenuEntries().add(getPizzaProsciuttoCipolla());
		menu.getMenuEntries().add(getCoke());
		menu.getMenuEntries().add(getLemonade());

		return menu;
	}

	@Bean
	Consummation getMargherita() {
		return new Pizza();
	}

	@Bean
	@Scope("prototype")
	public Ordine ordine() {
		return new Ordine();
	}

	@Bean
	@Scope("prototype")
	public Tavolo tavolo(Integer numero, Integer numeroMassimoCoperti, Boolean occupato) {
		return new Tavolo(numero, numeroMassimoCoperti, occupato);
	}

	@Bean
	Consummation getPizzaProsciutto() {
		return new HamTopping(new Pizza());
	}

	@Bean
	Consummation getPizzaCipolla() {
		return new OnionTopping(new Pizza());
	}

	@Bean
	Consummation getPizzaProsciuttoCipolla() {
		return new HamTopping(new OnionTopping(new Pizza()));
	}

	@Bean
	Consummation getCoke() {
		return new Coke(0.5);
	}

	@Bean
	Consummation getLemonade() {
		return new Lemonade(0.5);
	}

}
