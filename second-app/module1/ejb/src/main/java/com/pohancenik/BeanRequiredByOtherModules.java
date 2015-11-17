/**
 * 
 */
package com.pohancenik;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author pohancenik
 *
 */
@Stateless
@Local( BeanRequiredByOtherModulesLocal.class )
@Remote( BeanRequiredByOtherModulesRemote.class )
public class BeanRequiredByOtherModules implements BeanRequiredByOtherModulesLocal, BeanRequiredByOtherModulesRemote {

	private static final Logger log = LoggerFactory.getLogger( BeanRequiredByOtherModules.class );
	
	/* (non-Javadoc)
	 * @see com.pohancenik.BeanRequiredByOtherModulesRemote#getRemoteString()
	 */
	@Override
	public String getRemoteString() {
		return "Remote string";
	}

	/* (non-Javadoc)
	 * @see com.pohancenik.BeanRequiredByOtherModulesLocal#getLocalString()
	 */
	@Override
	public String getLocalString() {
		return "Local string";
	}

	// ************** LIFECYCLE LISTENERS *******************
	@PostConstruct
	@TransactionAttribute(NOT_SUPPORTED)
	public void postConstruct() {
		log.info( "Post-construct" );
	}
	
	@PreDestroy
	@TransactionAttribute(NOT_SUPPORTED)
	public void preDestroy() {
		log.info( "Pre-destroy" );
	}
}
