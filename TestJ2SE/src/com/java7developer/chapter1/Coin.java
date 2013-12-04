package com.java7developer.chapter1;

import java.util.Collection;
import java.util.HashMap;

/**
 * <p>Copyright:Copyright(c)2013</p>
 * <p>Company:Mopon</p>
 * <p>Description: </p>
 * @date 2013Äê11ÔÂ20ÈÕ
 * @author Ì·Ïè
 * @version 1.0
 */
public class Coin {
	int test = 123_567; 
	long test1 = 100_000L;
	@SafeVarargs
	public static <T> Collection<T> doSomething(T... entries){
		return null;
	}
	
	public static void main(String[] args) {
		HashMap<String, String> a = new HashMap<>();
		HashMap<String, String> b = new HashMap<>();
		doSomething(a,b);
	}
}
