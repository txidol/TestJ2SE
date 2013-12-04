/**
 * Program  : Same_Name.java
 * Author   : tanx
 * Create   : 2012-8-24 ÏÂÎç2:34:41
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
 * @2012-8-24 ÏÂÎç2:34:41
 */
public class Same_Name {

}

class Base {
	public static void f(){}
}

class Derived extends Base{
	public static void f(){}  // hides Base.f() 
}

class CircuitBreaker {
	public void f(int i)   {} // int overloading
	public void f(String s){} // String overloading
}

class WhoKonws {
	static String sentence = "I don't know";
	
	public static void main(String[] args) {
		String sentence = "I don't know"; //shadows static field
		System.out.println(sentence);     //prints local variable
	}
}
class Belt {
	@SuppressWarnings("unused")
	private final int size;
	public Belt(int size){ // Parameter shadows Belt.size
		this.size = size;
	}
}
class Obscure {
	@SuppressWarnings("unused")
	private String System;
	
	public static void main(String[] args) {
		//Next line won't compile :System refers to static field
		//System.out.println("hello,obscure world");    
	}
}