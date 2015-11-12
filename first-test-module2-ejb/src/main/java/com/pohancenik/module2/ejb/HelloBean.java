/**
 * 
 */
package com.pohancenik.module2.ejb;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * @author pohancenik
 *
 */
@Stateless
@Remote( AbleToSayHello.class )
public class HelloBean implements AbleToSayHello {

	/* (non-Javadoc)
	 * @see com.pohancenik.module2.ejb.AbleToSayHello#sayHello()
	 */
	@Override
	public String sayHello() {
		return "I'm saying hello to you stranger!";
	}

}
