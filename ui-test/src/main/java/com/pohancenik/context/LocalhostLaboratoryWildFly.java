/**
 * 
 */
package com.pohancenik.context;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.naming.remote.client.InitialContextFactory;

/**
 * @author pohancenik
 *
 */
public class LocalhostLaboratoryWildFly {

	public static Context prepareContext() throws NamingException {
		Properties jndiProps = new Properties();
		// context factory and URL of server
		jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, InitialContextFactory.class.getName());
		jndiProps.put(Context.PROVIDER_URL,"http-remoting://localhost:8080");
		// username
		jndiProps.put(Context.SECURITY_PRINCIPAL, "SuperAdmin");
		// password
		jndiProps.put(Context.SECURITY_CREDENTIALS, "1");
		Context context = new InitialContext(jndiProps);
		return context;
	}
	
}
