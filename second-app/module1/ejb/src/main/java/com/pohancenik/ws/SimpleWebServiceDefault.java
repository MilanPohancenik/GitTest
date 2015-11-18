package com.pohancenik.ws;

import java.util.Random;

import javax.ejb.Stateless;
import javax.jws.WebService;

@Stateless
@WebService( endpointInterface = "com.pohancenik.ws.SimpleWebService" )
public class SimpleWebServiceDefault implements SimpleWebService {

	public SimpleWebServiceDefault() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getSimpleString() {
		return "Simple-String";
	}

	@Override
	public int getSimpleIntegerInRange(int range) {
		Random random = new Random(System.currentTimeMillis());
		return random.nextInt(range);
	}

}
