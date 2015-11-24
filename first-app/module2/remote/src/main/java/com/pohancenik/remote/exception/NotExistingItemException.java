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
public class NotExistingItemException extends Exception {

	private static final long serialVersionUID = 4807392253931283428L;

}
