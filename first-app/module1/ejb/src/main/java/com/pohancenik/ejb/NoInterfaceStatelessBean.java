package com.pohancenik.ejb;

import javax.ejb.Stateless;

/**
 * 
 * A simple bean that implements no interface, so it only has a local interface 
 * equal to the class itself. It cannot be called from remote clients. 
 *  
 * @author pohancenik
 * 	
 */
@Stateless
public class NoInterfaceStatelessBean {
	
	public String saySomething() {
		return "I'm trying to say something man!";
	}
	
}
