/**
 * 
 */
package com.pohancenik;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.naming.remote.client.InitialContextFactory;

import com.pohancenik.module2.AbleToSayHello;
import com.pohancenik.module2.ShoppingCart;
import com.pohancenik.module2.exception.DuplicateItemException;

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
		ShoppingCart shoppingCart = (ShoppingCart) ctx.lookup( "first-test-app/first-test-module2/ShoppingCartBean!com.pohancenik.module2.ShoppingCart" );
		return shoppingCart;
	}
	
	public AbleToSayHello getAbleToSayHello(Context ctx) throws NamingException {
		AbleToSayHello helloBean = (AbleToSayHello) ctx.lookup("first-test-app/first-test-module2/HelloStatelessBean!com.pohancenik.module2.AbleToSayHello");
		return helloBean;
	}
	
	/**
	 * @param args
	 * @throws NamingException
	 * @throws DuplicateItemException 
	 */
	public static void main(String[] args) throws NamingException, DuplicateItemException {
		RemoteClientMain test = new RemoteClientMain();
		Context ctx = test.initCtx();

		System.out.println(test.getAbleToSayHello(ctx).sayHello());
	}

}
