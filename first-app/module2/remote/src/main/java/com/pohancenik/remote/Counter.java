/**
 * 
 */
package com.pohancenik.remote;

import javax.ejb.Remote;

/**
 * @author pohancenik
 *
 */
@Remote
public interface Counter {

	void increment();
	
	long value();
	
	void reset();
	
}
