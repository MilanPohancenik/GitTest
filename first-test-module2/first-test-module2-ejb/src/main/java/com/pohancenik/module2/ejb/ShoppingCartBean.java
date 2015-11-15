/**
 * 
 */
package com.pohancenik.module2.ejb;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.pohancenik.module2.ejb.exception.DuplicateItemException;
import com.pohancenik.module2.ejb.exception.NotExistingItemException;

/**
 * @author pohancenik
 *
 */
@Stateful
@Remote( ShoppingCart.class )
public class ShoppingCartBean implements ShoppingCart {

	private static final Logger log = Logger.getLogger( ShoppingCartBean.class.getName() );
	
	private Set<String> items;
	
	/* (non-Javadoc)
	 * @see com.pohancenik.module2.ejb.ShoppingCart#addItem(java.lang.String)
	 */
	@Override
	public void addItem(String id) throws DuplicateItemException {
		log.info("Adding item [" + id + "] to shopping cart");
		if ( items.contains( id )) {
			throw new DuplicateItemException();
		}
		items.add( id );
	}

	/* (non-Javadoc)
	 * @see com.pohancenik.module2.ejb.ShoppingCart#remoteItem(java.lang.String)
	 */
	@Override
	public void removeItem(String id) throws NotExistingItemException {
		log.info("Removing item [" + id + "] to shopping cart");
		if ( !items.contains( id ) ) {
			throw new NotExistingItemException();
		}
		items.remove( id );
	}
	
	/* (non-Javadoc)
	 * @see com.pohancenik.module2.ejb.ShoppingCart#get(java.lang.String)
	 */
	@Override
	public String get(String id) throws NotExistingItemException {
		if ( items.contains( id ) ) {
			for ( String itemId : items ) {
				if ( id.equals( itemId ) ) {
					return itemId;
				}
			}
		}
		throw new NotExistingItemException();
	}

	/* (non-Javadoc)
	 * @see com.pohancenik.module2.ejb.ShoppingCart#clear()
	 */
	@Override
	public void clear() {
		log.info("Clearing all items to shopping cart");
		items.clear();
	}
	
	/* (non-Javadoc)
	 * @see com.pohancenik.module2.ejb.ShoppingCart#getContent()
	 */
	@Override
	public Collection<String> getContent() {
		log.info("Returning content of shopping cart");
		return items;
	}

	/* (non-Javadoc)
	 * @see com.pohancenik.module2.ejb.ShoppingCart#remove()
	 */
	@Remove
	@Override
	public void remove() {
		log.info( "Removing cart-bean on request" );
	}
	
	// LIFECYCLE listeners
	@PostConstruct
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public void postConstruct() {
		log.info( "Post-construct" );
		items = new HashSet<String>();
	}
	
	@PreDestroy
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public void preDestroy() {
		log.info( "Pre-destroy" );
		items = null;
	}


}
