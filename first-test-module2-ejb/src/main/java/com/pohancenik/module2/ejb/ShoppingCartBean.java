/**
 * 
 */
package com.pohancenik.module2.ejb;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 * @author pohancenik
 *
 */
@Stateful
@Remote( ShoppingCart.class )
public class ShoppingCartBean implements ShoppingCart {

	private static final Logger log = Logger.getLogger( ShoppingCartBean.class.getName() );
	
	/* (non-Javadoc)
	 * @see com.pohancenik.module2.ejb.ShoppingCart#addItem(java.lang.String)
	 */
	@Override
	public void addItem(String id) {
		log.info("Adding item [" + id + "] to shopping cart");
	}

	/* (non-Javadoc)
	 * @see com.pohancenik.module2.ejb.ShoppingCart#remoteItem(java.lang.String)
	 */
	@Override
	public void removeItem(String id) {
		log.info("Removing item [" + id + "] to shopping cart");
	}

	/* (non-Javadoc)
	 * @see com.pohancenik.module2.ejb.ShoppingCart#clear()
	 */
	@Override
	public void clear() {
		log.info("Clearing all items to shopping cart");
	}
	
	/* (non-Javadoc)
	 * @see com.pohancenik.module2.ejb.ShoppingCart#remove()
	 */
	@Remove
	@Override
	public void remove() {
		log.info( "Removing cart-bean" );
	}
	
	// LIFECYCLE listeners
	@PostConstruct
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public void postConstruct() {
		log.info( "Post-construct" );
	}
	
	@PreDestroy
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public void preDestroy() {
		log.info( "Pre-destroy" );
	}


}
