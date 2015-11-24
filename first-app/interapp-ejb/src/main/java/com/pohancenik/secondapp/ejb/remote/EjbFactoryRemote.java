/**
 * 
 */
package com.pohancenik.secondapp.ejb.remote;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;

import com.pohancenik.BeanRequiredByOtherModulesRemote;

/**
 * @author pohancenik
 *
 */
@Stateless
public class EjbFactoryRemote {

	@EJB( lookup = "global/com.pohancenik.second-app/module1/BeanRequiredByOtherModules!com.pohancenik.BeanRequiredByOtherModulesRemote")
	private BeanRequiredByOtherModulesRemote requiredBean;
	
	@Produces
	@RequiredBeanRemote
	public BeanRequiredByOtherModulesRemote getBeanRequiredByOtherModulesRemote() {
		return requiredBean;
	}
	
}
