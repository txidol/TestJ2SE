/**
 * Program  : Loop.java
 * Author   : tanx
 * Create   : 2012-8-20 ÏÂÎç3:33:24
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
 * @author tanx
 * @version 1.0.0
 * @2012-8-20 ÏÂÎç3:33:24
 */
public class Loop {
	public static void main(String[] args) {
		int[][] t = { { 6, 5, 4, 3, 2, 1 }, { 1, 2 }, { 1, 2, 3 }, { 1, 2, 3, 4 }, { 1 } };
		int count = 0;
		int i = 0;
		try {
			
			while (true) {
				if (thirdElementIsThree(t[i++])) {
					count++;
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			System.out.println(count);
		}
		System.out.println(i);
		
	}

	private static boolean thirdElementIsThree(int[] a) {
		return a.length >= 3 & a[2] == 3;
	}
}
