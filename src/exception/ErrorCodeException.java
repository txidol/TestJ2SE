/**
 * Program  : ErrorCodeException.java
 * Author   : tanx
 * Create   : 2012-11-27 ÉÏÎç11:14:56
 *
 * Copyright 2012 by iPanel.TV Inc.,
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of iPanel.TV Inc.("Confidential Information").  
 * You shall not disclose such Confidential Information and shall 
 * use it only in accordance with the terms of the license agreement 
 * you entered into with iPanel.TV Inc.
 *
 */

package exception;

/**
* 
* @author   tanx
* @version  1.0.0
* @2012-11-27 ÉÏÎç11:14:56
*/
public class ErrorCodeException extends SelfException{
  
	private static final long serialVersionUID = 3881756450340093724L;
	
	private int errorCode;
	
	public ErrorCodeException() {
    	super();
    }
	
	public ErrorCodeException(String msg) {
    	super(msg);
    }	
	
	public ErrorCodeException(String msg,int errorCode) {
    	super(msg);
    	this.errorCode = errorCode;
    }

	public ErrorCodeException(int errorCode) {
    	super();
    	this.errorCode = errorCode;
    }
	
	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}	
	
	
}

