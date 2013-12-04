/**
 * Program  : X.java
 * Author   : tanx
 * Create   : 2012-4-19 ионГ11:47:54
 *
 * Copyright 2011 by iPanel.TV Inc.,
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of iPanel.TV Inc.("Confidential Information").  
 * You shall not disclose such Confidential Information and shall 
 * use it only in accordance with the terms of the license agreement 
 * you entered into with iPanel.TV Inc.
 *
 */

package problem;

/**
 * 
 * @author   tanx
 * @version  1.0.0
 * @2012-4-19 ионГ11:47:54
 */
public class X extends  Thread implements Runnable{
	public void run(){
		System.out.println("this is run()");
	}
	public static void main(String args[]){
		Thread t=new Thread(new X());
		t.start();
	}
	
}

