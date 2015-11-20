/**
 * 
 */
package com.pohancenik.ws;

import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 * @author pohancenik
 *
 */
@Stateless
@WebService(endpointInterface = "com.pohancenik.ws.SimpleWebService" )
public class SimpleWebServiceAdvanced implements SimpleWebService {

	public SimpleWebServiceAdvanced() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getSimpleString() {
		return "Advanced Simple-String";
	}

	@Override
	public int getSimpleIntegerInRange(int range) {
		return 0;
	}

}
