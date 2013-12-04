/**
 * Program  : Reflector.java
 * Author   : tanx
 * Create   : 2012-8-28 ����11:24:50
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

import java.util.*;
import java.lang.reflect.*;

/**
 * 
 * @author   tanx
 * @version  1.0.0
 * @2012-8-28 ����11:24:50
 */
public class Reflector {
	public static void main(String[] args) throws Exception{
		Set<String> s = new HashSet<String>();
		s.add("foo");
		Iterator<String> it  = s.iterator();
		
		//Method m = it.getClass().getMethod("hasNext");
		//���ֹ��ü����������⣬���Ƽ�ʹ��  
		//it.getClass()�õ���˽�е�Ƕ����KeyIterator
				
		//�滻ע�Ͳ��֣�ʹ��ע�Ͳ��֣��ᱨ�����Ͳ��ǹ�������
		Method m = Iterator.class.getMethod("hasNext");
		
		System.out.println(m.invoke(it));
	}
}

//package library;
//public class Api{
//	static class PackagePrivate{}
//	public static PackagePrivate member = new PackagePrivate();
//}
//
//package client;
//import library.Api;
//class Client{
//	public static void main(String[] args) {
//		//ע�Ͳ����޷�������   ���õ�������λ���������еķǹ�������
//		//System.out.println(Api.member.hashCode());
//		System.out.println(((Object)Api.member).hashCode());
//	}
//}

