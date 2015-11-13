package com.pohancenik.module2.ejb;

/**
 * @author pohancenik
 *
 */
public interface ShoppingCart {
	
	/**
	 * @param id
	 */
	void addItem( String id );
	
	/**
	 * @param id
	 */
	void removeItem( String id );
	
	/**
	 * 
	 */
	void clear();
	
	/**
	 * Just to discard this bean from container
	 */
	void remove();
	
}
