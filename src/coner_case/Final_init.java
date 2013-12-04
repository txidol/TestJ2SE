/**
 * Program  : Final_init.java
 * Author   : tanx
 * Create   : 2012-8-21 обнГ2:34:04
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

import java.util.Calendar;

/**
 * 
 * @author   tanx
 * @version  1.0.0
 * @2012-8-21 обнГ2:34:04
 */
public class Final_init {
	public static final Final_init INSTANCE = new Final_init();
	
	private final int beltSize;
	
	private static final int CURRENT_YEAR=
			Calendar.getInstance().get(Calendar.YEAR);
	
	private Final_init(){
		beltSize = CURRENT_YEAR - 1930;
	}
	
	public int beltSize(){
		return beltSize;
	}
	
	public static void main(String[] args) {
		System.out.println(INSTANCE.beltSize());
	}		
}

