/**
 * Program  : Creature.java
 * Author   : tanx
 * Create   : 2012-8-22 ионГ9:58:16
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
 * @2012-8-22 ионГ9:58:16
 */
public class Creature {
	private static long numCreated;
	public Creature(){
		synchronized(Creature.class){
			numCreated++;
		}
	}
	public static synchronized long numCreated(){
		return numCreated;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			new Creature();
		}
	}
}

