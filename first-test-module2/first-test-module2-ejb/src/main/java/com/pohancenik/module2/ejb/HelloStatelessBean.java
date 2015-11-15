/**
 * 
 */
package com.pohancenik.module2.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pohancenik.module2.AbleToSayHello;

/**
 * @author pohancenik
 *
 */
@Stateless
@Remote(AbleToSayHello.class)
public class HelloStatelessBean implements AbleToSayHello {

	private static final Logger log = LoggerFactory.getLogger( HelloStatelessBean.class );
	
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
	@TransactionAttribute( TransactionAttributeType.NOT_SUPPORTED )
	public void postConstruct() {
		log.info("Post-construct");
	}

	@PreDestroy
	@TransactionAttribute( TransactionAttributeType.NOT_SUPPORTED )
	public void preDestroy() {
		log.info("Pre-destroy");
	}
}
