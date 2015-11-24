package com.pohancenik.simulation;

import com.pohancenik.remote.ShoppingCart;
import com.pohancenik.remote.exception.DuplicateItemException;

public abstract class AbstractShopper implements Shopper {

	private ShoppingCart cart;
	
	@Override
	public ShoppingCart getCart() {
		return cart;
	}

	@Override
	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}

	@Override
	public void doShopping() {
		if ( cart == null ) {
			throw new IllegalStateException("I have no shopping cart for shopping!");
		}
		try {
			putYourItemsInCart( cart );
		} catch (DuplicateItemException e) {
			System.out.println( this.getClass().getSimpleName() + ": Ohh, my item [" + e.getItemId() + "] is already in shopping cart!" );
		}
		System.out.println( this.getClass().getSimpleName() + ": All items added");
	}

	@Override
	public void endShopping() {
		if ( cart == null ) {
			throw new IllegalStateException("Someone took my shopping cart away!");
		}
		cart.clear();
		cart = null;
		System.out.println( this.getClass().getSimpleName() + ": I've completed my shopping!");
	}
	
	protected abstract void putYourItemsInCart(ShoppingCart cart) throws DuplicateItemException;
}
