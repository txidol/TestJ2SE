/**
 * Program  : Range.java
 * Author   : tanx
 * Create   : 2012-5-2 下午3:16:39
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

package util;

/**
 * 构建简单的整数序列
 * @author   tanx
 * @version  1.0.0
 * @2012-5-2 下午3:16:39
 */
public class Range {
	
	//Produce a sequence [0..n)
	public static int[] range(int n){
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			result[i] = i;
		}
		return result;
	}
	
	public static int[] range(int start, int end){
		int s = end - start;
		int[] result = new int[s];
		for (int i = 0; i < s; i++) {
			result[i] = start + i;
		}
		return result;
	}
	
	public static int[] range(int start, int end,int step){
		int s = (end - start)/step;
		int[] result = new int[s];
		for (int i = 0; i < s; i++) {
			result[i] = start + (i*step);
		}
		return result;
	}
}

