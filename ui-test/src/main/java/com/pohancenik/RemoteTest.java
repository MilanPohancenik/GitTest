/**
 * 
 */
package com.pohancenik;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.pohancenik.module2.ejb.AbleToSayHello;

/**
 * @author pohancenik
 *
 */
public class RemoteTest {

	public Context initCtx() throws NamingException {

//		final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
		Properties jndiProps = new Properties();
		jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		jndiProps.put(Context.PROVIDER_URL,"http-remoting://localhost:8080");
		jndiProps.put("jboss.naming.client.ejb.context", true);
		// username
		jndiProps.put(Context.SECURITY_PRINCIPAL, "SuperAdmin");
		// password
		jndiProps.put(Context.SECURITY_CREDENTIALS, "1");
//		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
//		final Context context = new InitialContext(jndiProperties);
		
		// Properties jndiProps = new Properties();
		// jndiProps.put(Context.INITIAL_CONTEXT_FACTORY,
		// "org.jboss.naming.HttpNamingContextFactory"
		// );//org.jboss.naming.remote.client.InitialContextFactory.class.getName());
		// jndiProps.put(Context.SECURITY_PRINCIPAL, "SuperAdmin");
		// jndiProps.put(Context.SECURITY_CREDENTIALS, "1");
		// jndiProps.put(Context.PROVIDER_URL, "http://localhost:8080");
		// jndiProps.put("jboss.naming.client.ejb.context", true);
		// jndiProps.put("jboss.naming.client.connect.options.org.xnio.Options.SASL_POLICY_NOPLAINTEXT","false");

		// create a context passing these properties
		Context ctx = new InitialContext( jndiProps );
		// lookup
		return ctx;
	}

	/**
	 * @param args
	 * @throws NamingException
	 */
	public static void main(String[] args) throws NamingException {
		RemoteTest test = new RemoteTest();
		Context ctx = test.initCtx();
		AbleToSayHello hello = (AbleToSayHello) ctx.lookup("first-test-ear-0.0.1-SNAPSHOT/first-test-module2-ejb-0.0.1-SNAPSHOT/HelloBean!com.pohancenik.module2.ejb.AbleToSayHello");
		System.out.println(hello.sayHello());
	}

}
