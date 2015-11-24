/**
 * 
 */
package com.pohancenik.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pohancenik.remote.Counter;

/**
 * @author pohancenik
 *
 */
@Singleton
public class SingletonSimpleCounterBean implements Counter {

	private long internalValue = 0L;
	
	private static final Logger log = LoggerFactory.getLogger( SingletonSimpleCounterBean.class );
	
	/* (non-Javadoc)
	 * @see com.pohancenik.module2.ejb.Counter#increment()
	 */
	@Override
	public void increment() {
		internalValue++;
	}

	/* (non-Javadoc)
	 * @see com.pohancenik.module2.ejb.Counter#value()
	 */
	@Override
	public long value() {
		return internalValue;
	}

	/* (non-Javadoc)
	 * @see com.pohancenik.module2.ejb.Counter#reset()
	 */
	@Override
	public void reset() {
		internalValue = 0L;
	}

	@PostConstruct
	@TransactionAttribute( TransactionAttributeType.NOT_SUPPORTED )
	public void postConstruct() {
		log.info("Pre-construction");
	}
	
	@PreDestroy
	@TransactionAttribute( TransactionAttributeType.NOT_SUPPORTED )
	public void preDestroy() {
		log.info("Pre-destroy");
	}
}
