package com.pohancenik;

import com.pohancenik.ws.client.SimpleWebService;
import com.pohancenik.ws.client.SimpleWebServiceDefaultService;

public class WsClient {
	
	private SimpleWebService webService;
	
	public void initWebService() {
		SimpleWebServiceDefaultService serviceStub = new SimpleWebServiceDefaultService();
		webService = serviceStub.getSimpleWebServiceDefaultPort();
	}
	
	public String getSimpleStringFromWs() {
		return webService.getSimpleString();
	}
	
	public int getIntegerInRange( int range ) {
		return webService.getSimpleIntegerInRange( range );
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WsClient wsClient = new WsClient();
		wsClient.initWebService();
		
		System.out.println( "Answer from web-service from getSimpleString() [" + wsClient.getSimpleStringFromWs() + "]" );
		System.out.println( "Answer from web-service from getIntegerInRange() [" + wsClient.getIntegerInRange( 250 ) + "]");
	}

}
