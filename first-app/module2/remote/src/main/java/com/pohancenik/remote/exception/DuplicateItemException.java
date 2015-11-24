/**
 * 
 */
package com.pohancenik.remote.exception;

import javax.ejb.ApplicationException;

/**
 * @author pohancenik
 *
 */
@ApplicationException(rollback = true)
public class DuplicateItemException extends Exception {

	private static final long serialVersionUID = -2919209627579409834L;

	private String itemId;
	
	public DuplicateItemException(String itemId) {
		this.itemId = itemId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	
}
