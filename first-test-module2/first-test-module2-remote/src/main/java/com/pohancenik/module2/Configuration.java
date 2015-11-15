/**
 * 
 */
package com.pohancenik.module2;

/**
 * @author pohancenik
 *
 */
public interface Configuration {

	State getState();
	
	void setMaxRows( int maxRows );
	
	int getMaxRows();
	
	void setTimeout( long timeoutInMillis );
	
	long getTimeout();
	
}
