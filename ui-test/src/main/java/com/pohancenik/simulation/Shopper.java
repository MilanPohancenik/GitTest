package com.pohancenik.simulation;

import com.pohancenik.remote.ShoppingCart;

public interface Shopper {
	
	void doShopping();
	
	void endShopping();
	
	ShoppingCart getCart();

	void setCart(ShoppingCart cart);
}
