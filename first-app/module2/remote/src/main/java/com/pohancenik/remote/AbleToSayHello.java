package com.pohancenik.remote;

import javax.ejb.Remote;

/**
 * @author pohancenik
 *
 */
@Remote
public interface AbleToSayHello {
	
	String sayHelloFromLocal();
	
	String sayHelloFromRemote();
	
}
