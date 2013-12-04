/**
 * Program  : ShowPropertes.java
 * Author   : tanx
 * Create   : 2012-3-30 обнГ5:05:09
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
 * @2012-3-30 обнГ5:05:09
 */
public class ShowPropertes {
	public static void main(String[] args) {
		System.getProperties().list(System.out);		
		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getProperty("java.library.path"));
	}
}

