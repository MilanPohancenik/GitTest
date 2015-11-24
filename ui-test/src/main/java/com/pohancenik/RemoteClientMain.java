/**
 * 
 */
package com.pohancenik;

import javax.naming.Context;
import javax.naming.NamingException;

import com.pohancenik.context.LocalhostLaboratoryWildFly;
import com.pohancenik.remote.AbleToSayHello;
import com.pohancenik.remote.ShoppingCart;
import com.pohancenik.remote.exception.DuplicateItemException;

/**
 * @author pohancenik
 *
 */
public class RemoteClientMain {

	public ShoppingCart getCart(Context ctx) throws NamingException {
		ShoppingCart shoppingCart = (ShoppingCart) ctx.lookup( "first-app/module2/ShoppingCartBean!com.pohancenik.module2.ShoppingCart" );
		return shoppingCart;
	}
	
	public AbleToSayHello getAbleToSayHello(Context ctx) throws NamingException {
		AbleToSayHello helloBean = (AbleToSayHello) ctx.lookup( "com.pohancenik.first-app/module2/HelloStatelessBean!com.pohancenik.remote.AbleToSayHello" );
		return helloBean;
	}
	
	/**
	 * @param args
	 * @throws NamingException
	 * @throws DuplicateItemException 
	 */
	public static void main(String[] args) throws NamingException, DuplicateItemException {
		RemoteClientMain test = new RemoteClientMain();
		Context ctx = LocalhostLaboratoryWildFly.prepareContext();

		System.out.println(test.getAbleToSayHello(ctx).sayHelloFromLocal());
		
		System.out.println(test.getAbleToSayHello(ctx).sayHelloFromRemote());
	}

}
