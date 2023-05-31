package Simone.menuapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import Simone.menuapp.entities.Consummation;
import Simone.menuapp.entities.Menu;
import Simone.menuapp.entities.Ordine;
import Simone.menuapp.entities.Product;
import Simone.menuapp.entities.Tavolo;
import Simone.menuapp.entities.drinks.Coke;
import Simone.menuapp.entities.drinks.Drink;
import Simone.menuapp.entities.drinks.Lemonade;
import Simone.menuapp.entities.pizzas.Pizza;
import Simone.menuapp.entities.toppings.HamTopping;
import Simone.menuapp.entities.toppings.OnionTopping;

@Component
public class MenuRunner implements CommandLineRunner {

	@Autowired
	private AnnotationConfigApplicationContext ctx;

	@Override
	public void run(String... args) throws Exception {
		Menu menu = ctx.getBean(Menu.class);
		Tavolo tavolo = new Tavolo(1, 5, true);
		Double costoCoperto = 2.5;

		Ordine ordine = creaOrdine(tavolo, 3, costoCoperto);
		valorizzaOrdine(ordine);
		stampaOrdine(ordine);

		menu.print();
		ctx.close();
	}

	private void valorizzaOrdine(Ordine ordine) {
		for (int i = 0; i < 3; i++) {
			Pizza pizza = ctx.getBean(Pizza.class);
			ordine.addMenuItem(pizza);
		}

		Consummation pizza = ctx.getBean(Pizza.class);
		pizza = new HamTopping(pizza);
		ordine.addMenuItem(pizza);

		pizza = ctx.getBean(Pizza.class);
		pizza = new OnionTopping(pizza);
		ordine.addMenuItem(pizza);

		pizza = ctx.getBean(Pizza.class);
		pizza = new HamTopping(new OnionTopping(pizza));
		ordine.addMenuItem(pizza);

		Drink drink = ctx.getBean(Coke.class);
		ordine.addMenuItem(drink);

		drink = ctx.getBean(Lemonade.class);
		ordine.addMenuItem(drink);
	}

	public Ordine creaOrdine(Tavolo tavolo, Integer numeroCoperti, Double costoCoperto) {
		Ordine ordine = ctx.getBean(Ordine.class);
		ordine.setTavolo(tavolo);
		ordine.setNumeroCoperti(numeroCoperti);
		ordine.setNumeroOrdine(1);
		ordine.setCostoCoperto(costoCoperto);
		return ordine;
	}

	public void stampaOrdine(Ordine ordine) {
		System.out.println("****** ORDINE ******");
		System.out.println("Numero ordine: " + ordine.getNumeroOrdine());
		System.out.println("Numero coperti: " + ordine.getNumeroCoperti());
		System.out.println("Numero Tavolo: " + ordine.getTavolo().getNumero());
		System.out.println("Stato ordine: " + ordine.getStato());
		System.out.println();
		for (Product item : ordine.getOrdinato().keySet()) {
			System.out.println(item.getName() + " - Quantità: " + ordine.getOrdinato().get(item));
		}
		System.out.println();
		System.out.println("Totale €: " + ordine.getTotale());
	}
}
