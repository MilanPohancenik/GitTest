/**
 * 
 */
package com.pohancenik;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.naming.remote.client.InitialContextFactory;

import com.pohancenik.module2.ejb.ShoppingCart;
import com.pohancenik.module2.ejb.exception.DuplicateItemException;

/**
 * @author pohancenik
 *
 */
public class RemoteClientMain {

	public Context initCtx() throws NamingException {
		Properties jndiProps = new Properties();
		// context factory and URL of server
		jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, InitialContextFactory.class.getName());
		jndiProps.put(Context.PROVIDER_URL,"http-remoting://localhost:8080");
		// username
		jndiProps.put(Context.SECURITY_PRINCIPAL, "SuperAdmin");
		// password
		jndiProps.put(Context.SECURITY_CREDENTIALS, "1");

		// create a context passing these properties
		Context ctx = new InitialContext( jndiProps );
		return ctx;
	}

	public ShoppingCart getCart(Context ctx) throws NamingException {
		ShoppingCart shoppingCart = (ShoppingCart) ctx.lookup( "first-test-ear-0.0.1-SNAPSHOT/first-test-module2-ejb-0.0.1-SNAPSHOT/ShoppingCartBean!com.pohancenik.module2.ejb.ShoppingCart" );
		return shoppingCart;
	}
	
	/**
	 * @param args
	 * @throws NamingException
	 * @throws DuplicateItemException 
	 */
	public static void main(String[] args) throws NamingException, DuplicateItemException {
		RemoteClientMain test = new RemoteClientMain();
		Context ctx = test.initCtx();
		
//		AbleToSayHello hello = (AbleToSayHello) ctx.lookup("first-test-ear-0.0.1-SNAPSHOT/first-test-module2-ejb-0.0.1-SNAPSHOT/HelloBean!com.pohancenik.module2.ejb.AbleToSayHello");
//		System.out.println(hello.sayHello());
		
		ShoppingCart cart = test.getCart(ctx);
		cart.addItem("Book-1");
		cart.addItem("Book-2");
		
		System.out.println("Content of shopping cart : ");
		for ( String item : cart.getContent() ) {
			System.out.println( " - " + item );
		}
		
		cart.clear();
		cart.remove();
	}

}
