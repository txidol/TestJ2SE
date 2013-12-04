/**
 * Program  : ss.java
 * Author   : tanx
 * Create   : 2012-11-26 下午6:13:44
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

import org.junit.Test;

/**
 * 
 * @author tanx
 * @version 1.0.0
 * @2012-11-26 下午6:13:44
 */
public class TestSelfException {

	public void run() throws SelfException {
		throw new SelfException("自测试异常！");
	}
    @Test
    public void test() throws SelfException {
		try {
			new TestSelfException().test();
		} catch (SelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			new TestSelfException().test();
		} catch (SelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
