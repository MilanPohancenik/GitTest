/**
 * 
 */
package com.pohancenik;

import javax.ejb.Remote;

/**
 * @author pohancenik
 *
 */
@Remote
public interface BeanRequiredByOtherModulesRemote {

	String getRemoteString();
	
}
