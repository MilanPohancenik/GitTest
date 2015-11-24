/**
 * 
 */
package com.pohancenik.simulation;

import com.pohancenik.remote.ShoppingCart;
import com.pohancenik.remote.exception.DuplicateItemException;

/**
 * @author pohancenik
 *
 */
public class FemaleShopper extends AbstractShopper implements Shopper {

	@Override
	protected void putYourItemsInCart(ShoppingCart cart) throws DuplicateItemException {
		cart.addItem("Makeup");
		cart.addItem("Toothbrush");
		cart.addItem("Toothpaste");
		cart.addItem("Nail-polish");
		cart.addItem("Hair-dryer");
		cart.addItem("Lipgloss");
		cart.addItem("Toothbrush");
	}

}
