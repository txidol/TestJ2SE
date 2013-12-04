/**
 * Program  : Outer.java
 * Author   : tanx
 * Create   : 2012-8-28 ионГ10:23:31
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

package coner_case;

import java.lang.reflect.Constructor;

/**
 * 
 * @author   tanx
 * @version  1.0.0
 * @2012-8-28 ионГ10:23:31
 */
public class Outer {
	public static void main(String[] args)throws Exception{
		new Outer().greetWorld();
	}
	
	private void greetWorld()throws Exception{
		//System.out.println(Inner.class.newInstance());
		Constructor<Inner> c = Inner.class.getConstructor(Outer.class);
		System.out.println(c.newInstance(Outer.this));
	}
	
	//public static class Inner{
	public class Inner{
		public String toString(){
			return "Hello World";
		}
	}
}

