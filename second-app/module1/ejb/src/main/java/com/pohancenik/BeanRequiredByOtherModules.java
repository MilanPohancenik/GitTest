/**
 * 
 */
package com.pohancenik;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * @author pohancenik
 *
 */
@Stateless
@Local( BeanRequiredByOtherModulesLocal.class )
@Remote( BeanRequiredByOtherModulesRemote.class )
public class BeanRequiredByOtherModules implements BeanRequiredByOtherModulesLocal, BeanRequiredByOtherModulesRemote {

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

}
