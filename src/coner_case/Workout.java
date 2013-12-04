/**
 * Program  : Workout.java
 * Author   : tanx
 * Create   : 2012-8-21 ионГ10:20:25
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
 * @2012-8-21 ионГ10:20:25
 */
public class Workout {
	public static void main(String[] args){
		workHard();
		System.out.println("It's nap time.");
	}
	
	private static void workHard(){
		try{
			workHard();
		}finally{
			workHard();
		}
	}
}

