package com.pohancenik.ejb;

import javax.ejb.Stateless;

@Stateless
public class NoInterfaceStatelessBean {
	
	public String saySomething() {
		return "I'm trying to say something man!";
	}
	
}
