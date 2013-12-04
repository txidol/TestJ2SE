/**
 * Program  : MyThing.java
 * Author   : tanx
 * Create   : 2012-8-21 обнГ5:11:46
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

/**
 * 
 * @author   tanx
 * @version  1.0.0
 * @2012-8-21 обнГ5:11:46
 */
public class MyThing extends Thing{
	private final int arg;
	
	public MyThing() {
		// TODO Auto-generated constructor stub
		this(1);
	}
	
	private MyThing(int i){
		super(i);
		arg = i;
		System.out.println(arg);
	}
	
	public static void main(String[] args) {
		new MyThing();
	
	}
	
}

