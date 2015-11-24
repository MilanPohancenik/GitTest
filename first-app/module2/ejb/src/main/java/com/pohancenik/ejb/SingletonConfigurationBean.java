/**
 * 
 */
package com.pohancenik.ejb;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.AccessTimeout;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pohancenik.remote.Configuration;
import com.pohancenik.remote.State;

/**
 * @author pohancenik
 *
 */
@Startup
@Singleton
@ConcurrencyManagement( ConcurrencyManagementType.CONTAINER )
@Lock( LockType.READ )
@AccessTimeout( unit = TimeUnit.SECONDS, value = 10 )
public class SingletonConfigurationBean implements Configuration {

	private State internalState = State.INIT;
	
	private int maxRows = 0;
	
	private long timeoutInMillis = 60000L; // 1 minute by default 
	
	private static final Logger log = LoggerFactory.getLogger( SingletonConfigurationBean.class );
	
	/* (non-Javadoc)
	 * @see com.pohancenik.module2.Configuration#getState()
	 */
	@Override
	public State getState() {
		return internalState;
	}

	/* (non-Javadoc)
	 * @see com.pohancenik.module2.Configuration#setMaxRows(int)
	 */
	@Lock( LockType.WRITE )
	@Override
	public void setMaxRows(int maxRows) {
		this.internalState = State.SYNCHRONIZING;
		this.maxRows = maxRows;
		this.internalState = State.RUNNING;
	}

	/* (non-Javadoc)
	 * @see com.pohancenik.module2.Configuration#getMaxRows()
	 */
	@Override
	public int getMaxRows() {
		return maxRows;
	}

	/* (non-Javadoc)
	 * @see com.pohancenik.module2.Configuration#setTimeout(long)
	 */
	@Lock( LockType.WRITE )
	@Override
	public void setTimeout(long timeoutInMillis) {
		this.internalState = State.SYNCHRONIZING;
		this.timeoutInMillis = timeoutInMillis;
		this.internalState = State.RUNNING;
	}

	/* (non-Javadoc)
	 * @see com.pohancenik.module2.Configuration#getTimeout()
	 */
	@Override
	public long getTimeout() {
		return timeoutInMillis;
	}

	@PostConstruct
	@TransactionAttribute( TransactionAttributeType.NOT_SUPPORTED )
	public void postConstruct() {
		internalState = State.RUNNING;
		log.info( "post-construct" );
	}
	
	@PreDestroy
	@TransactionAttribute( TransactionAttributeType.NOT_SUPPORTED )
	public void preDestroy() {
		internalState = State.DESTROYED;
		log.info( "pre-destroy" );
	}
}
