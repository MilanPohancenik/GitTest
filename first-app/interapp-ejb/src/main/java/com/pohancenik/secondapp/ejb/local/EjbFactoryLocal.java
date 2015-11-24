/**
 * 
 */
package com.pohancenik.secondapp.ejb.local;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;

import com.pohancenik.BeanRequiredByOtherModulesLocal;

/**
 * @author pohancenik
 *
 */
@Stateless
public class EjbFactoryLocal {

	@EJB(lookup="global/com.pohancenik.second-app/module1/BeanRequiredByOtherModules!com.pohancenik.BeanRequiredByOtherModulesLocal")
	private BeanRequiredByOtherModulesLocal requiredBean;
	
	@Produces
	@RequiredBeanLocal
	public BeanRequiredByOtherModulesLocal getBeanRequiredByOtherModulesLocal() {
		return requiredBean;
	}
	
}
