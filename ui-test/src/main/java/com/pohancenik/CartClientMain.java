package com.pohancenik;

import javax.naming.Context;
import javax.naming.NamingException;

import com.pohancenik.context.LocalhostLaboratoryWildFly;
import com.pohancenik.remote.ShoppingCart;
import com.pohancenik.remote.exception.DuplicateItemException;
import com.pohancenik.simulation.FemaleShopper;
import com.pohancenik.simulation.MaleShopper;
import com.pohancenik.simulation.Shopper;

public class CartClientMain {

	public static void main(String[] args) throws NamingException, DuplicateItemException {
		Context context = LocalhostLaboratoryWildFly.prepareContext();
		ShoppingCart cart = (ShoppingCart) context.lookup("com.pohancenik.first-app/module2/ShoppingCartBean!com.pohancenik.remote.ShoppingCart");
		// male shopper example
		Shopper maleShopper = new MaleShopper();
		maleShopper.setCart(cart);
		maleShopper.doShopping();
		maleShopper.endShopping();
		// female shopper example
		Shopper femaleShopper = new FemaleShopper();
		femaleShopper.setCart(cart);
		femaleShopper.doShopping();
		femaleShopper.endShopping();
		cart.remove(); // maybe destroying the cart after shopping, in a shopping center, would not be a good idea :)))
	}
	
}
