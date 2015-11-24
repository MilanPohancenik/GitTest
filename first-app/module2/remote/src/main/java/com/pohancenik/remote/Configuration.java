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
public interface Configuration {

	State getState();
	
	void setMaxRows( int maxRows );
	
	int getMaxRows();
	
	void setTimeout( long timeoutInMillis );
	
	long getTimeout();
	
}
