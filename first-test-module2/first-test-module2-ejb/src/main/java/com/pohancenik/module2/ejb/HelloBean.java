/**
 * 
 */
package com.pohancenik.module2.ejb;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * @author pohancenik
 *
 */
@Stateless
@Remote(AbleToSayHello.class)
public class HelloBean implements AbleToSayHello {

	private static final Logger log = Logger.getLogger( HelloBean.class.getName() );
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pohancenik.module2.ejb.AbleToSayHello#sayHello()
	 */
	@Override
	public String sayHello() {
		log.info( "Answering client" );
		return "I'm saying hello to you stranger!";
	}

	// LIFECYCLE listeners
	@PostConstruct
	public void postConstruct() {
		log.info("Post-construct");
	}

	@PreDestroy
	public void preDestroy() {
		log.info("Pre-destroy");
	}
}
