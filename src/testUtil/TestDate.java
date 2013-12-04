/**
 * Program  : TestDate.java
 * Author   : tanx
 * Create   : 2012-12-29 上午9:48:40
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

package testUtil;

import java.util.Date;

/**
 * 
 * @author   tanx
 * @version  1.0.0
 * @2012-12-29 上午9:48:40
 */
public class TestDate {
public static void main(String[] args) {
	long mailTime = new Date().getTime();
	System.out.println(mailTime);
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(new Date().getTime()); ;
}
}

