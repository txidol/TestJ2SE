/**
 * Program  : TestSystem.java
 * Author   : tanx
 * Create   : 2012-12-28 下午2:25:20
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

import java.util.Enumeration;
import java.util.Properties;

/**
 * 
 * @author   tanx
 * @version  1.0.0
 * @2012-12-28
 */
public class TestSystem {
public static void main(String[] args) {
	Properties a = System.getProperties();
	Enumeration<?> s = a. propertyNames();
	while ( s.hasMoreElements()) {
		Object type = (Object) s.nextElement();
		System.out.println(type);
	}
	System.out.println(System.getProperty("user.name"));
}
}

