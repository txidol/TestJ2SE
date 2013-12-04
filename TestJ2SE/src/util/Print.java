/**
 * Program  : Print.java
 * Author   : tanx
 * Create   : 2012-5-2 ����2:21:45
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

import java.io.PrintStream;

/**
 * ϵͳ��ӡ������ʹ��Java SE5��̬���뷽��
 * @author   tanx
 * @version  Java SE5
 * @2012-5-2 ����2:21:45
 */
public class Print {
	public static void print(Object obj){
		System.out.println(obj);
	}
	// new line
	public static void print(){
		System.out.println();
	}
	// ������
	public static void printnb(Object obj){
		System.out.print(obj);
	}
	// new Java SE5 printf()
	public static PrintStream printf(String dormat,Object obj){
		return System.out.printf(dormat,obj);
	}
}

