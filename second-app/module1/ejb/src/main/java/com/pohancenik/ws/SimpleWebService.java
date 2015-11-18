package com.pohancenik.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface SimpleWebService {
	
	/**
	 * Returns back a "Simple-String" message to the client
	 * @return
	 */
	@WebMethod
	String getSimpleString();
	
	/**
	 * Generates a random integer based on the range
	 * @param range
	 * @return
	 */
	@WebMethod
	int getSimpleIntegerInRange(byte range);
	
}
