/**
 * Program  : ShortRoute.java
 * Author   : tanx
 * Create   : 2012-4-24 ÉÏÎç10:39:35
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

package object;


/**
 * 
 * @author   tanx
 * @version  1.0.0
 * @2012-4-24 ÉÏÎç10:39:35
 */
public class ShortRoute {
	static boolean test(int a){
		System.out.println("s1");
		return a>3;
	}
	public static void main(String[] args) {
		int a = 3;
		if(a==3||test(a)){
			System.out.println("s");
		}
	}
}

