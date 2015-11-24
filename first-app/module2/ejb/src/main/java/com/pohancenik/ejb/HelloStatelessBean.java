/**
 * 
 */
package com.pohancenik.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pohancenik.BeanRequiredByOtherModulesLocal;
import com.pohancenik.BeanRequiredByOtherModulesRemote;
import com.pohancenik.remote.AbleToSayHello;
import com.pohancenik.secondapp.ejb.local.RequiredBeanLocal;
import com.pohancenik.secondapp.ejb.remote.RequiredBeanRemote;

/**
 * @author pohancenik
 *
 */
@Stateless
public class HelloStatelessBean implements AbleToSayHello {

	private static final Logger log = LoggerFactory.getLogger( HelloStatelessBean.class );
	
	@Inject
	@RequiredBeanLocal
	private BeanRequiredByOtherModulesLocal requiredBeanLocal;
	
	@Inject
	@RequiredBeanRemote
	private BeanRequiredByOtherModulesRemote requiredBeanRemote;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pohancenik.module2.ejb.AbleToSayHello#sayHello()
	 */
	@Override
	public String sayHelloFromLocal() {
		log.info( "Answering client" );
		log.info( "Talking from the required local bean > " + requiredBeanLocal.getLocalString() );
		return requiredBeanLocal.getLocalString() + " + I'm saying hello to you stranger!";
	}
	
	/* (non-Javadoc)
	 * @see com.pohancenik.remote.AbleToSayHello#sayHelloFromRemote()
	 */
	@Override
	public String sayHelloFromRemote() {
		log.info( "Answering client" );
		log.info( "Talking from the required remote bean > " + requiredBeanRemote.getRemoteString() );
		return requiredBeanRemote.getRemoteString() + " + I'm saying hello to you stranger!";
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
