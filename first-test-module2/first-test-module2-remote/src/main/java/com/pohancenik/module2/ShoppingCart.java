package com.pohancenik.module2;

import java.util.Collection;

import com.pohancenik.module2.exception.DuplicateItemException;
import com.pohancenik.module2.exception.NotExistingItemException;

/**
 * @author pohancenik
 *
 */
public interface ShoppingCart {
	
	/**
	 * @param id
	 * @throws DuplicateItemException
	 */
	void addItem( String id ) throws DuplicateItemException;
	
	/**
	 * @param id
	 * @throws NotExistingItemException 
	 */
	void removeItem( String id ) throws NotExistingItemException;
	
	/**
	 * @param id
	 * @throws NotExistingItemException
	 */
	String get( String id ) throws NotExistingItemException;
	
	/**
	 * @return
	 */
	Collection<String> getContent();
	
	/**
	 * 
	 */
	void clear();
	
	/**
	 * Just to discard this bean from container
	 */
	void remove();
	
}
