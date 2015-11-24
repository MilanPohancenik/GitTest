package com.pohancenik.simulation;

import com.pohancenik.remote.ShoppingCart;
import com.pohancenik.remote.exception.DuplicateItemException;

public class MaleShopper extends AbstractShopper implements Shopper {

	@Override
	public void putYourItemsInCart(ShoppingCart cart) throws DuplicateItemException {
		cart.addItem("Toothbrush");
		cart.addItem("Towel");
		cart.addItem("Toothpaste");
		cart.addItem("Soap");
	}

}
