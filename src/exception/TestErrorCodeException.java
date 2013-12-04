/**
 * Program  : ss.java
 * Author   : tanx
 * Create   : 2012-11-26 ����6:13:44
 *
 * Copyright 2012 by iPanel.TV Inc.,
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of iPanel.TV Inc.("Confidential Information").  
 * You shall not disclose such Confidential Information and shall 
 * use it only in accordance with the terms of the license agreement 
 * you entered into with iPanel.TV Inc.
 *
 */
package exception;

import junit.framework.Assert;

import org.junit.Test;

/**
 * 
 * @author tanx
 * @version 1.0.0
 * @2012-11-26 ����6:13:44
 */
public class TestErrorCodeException {

	public void runErrorCode() throws ErrorCodeException {
		throw new ErrorCodeException(ErrorCodeEnum.NULL.getName());		
	}	
	
	public void runErrorCode1() throws ErrorCodeException {
		throw new ErrorCodeException("�Բ����쳣��",ErrorCodeEnum.NULL.getIndex());	
		//throw new ErrorCodeException("�Բ����쳣��",1);//���Ƽ�
	}
	
	public void runErrorCode2() throws ErrorCodeException {
		throw new ErrorCodeException(ErrorCodeEnum.NULL.getIndex());
		//throw new ErrorCodeException(1);//���Ƽ�
	}
    @Test
    public void testErrorCode() {
		try {
			runErrorCode();
		} catch (ErrorCodeException e) {
			e.printStackTrace();			
			System.out.println("�����" + e.getMessage() + " ��ô��");
			Assert.assertEquals("������", e.getMessage());
		}
	}
    @Test
    public void testErrorCode1(){
		try {
			runErrorCode1();
		} catch (ErrorCodeException e) {
			e.printStackTrace();			
			System.out.println("�����" + ErrorCodeEnum.getName(e.getErrorCode()) + " ��ô��");			
		}
	}
    @Test
    public void testErrorCode2() {
		try {
			runErrorCode2();
		} catch (ErrorCodeException e) {
			e.printStackTrace();			
			System.out.println("�����" + ErrorCodeEnum.getName(e.getErrorCode()) + " ��ô��");			
		}
	}
	public static void main(String[] args) {
		new TestErrorCodeException().testErrorCode();
		System.out.println("--------------");
		new TestErrorCodeException().testErrorCode1();
		System.out.println("--------------");
		new TestErrorCodeException().testErrorCode2();
	}

}
