/**
 * 
 */
package com.pohancenik;

import javax.ejb.Local;

/**
 * @author pohancenik
 *
 */
@Local
public interface BeanRequiredByOtherModulesLocal {

	String getLocalString();
	
}
