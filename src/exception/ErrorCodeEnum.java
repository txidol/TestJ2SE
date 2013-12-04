/**
 * Program  : SelfErrorCodeDefines.java
 * Author   : tanx
 * Create   : 2012-11-27 ����11:25:01
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

/**
 * 
 * @author   tanx
 * @version  1.0.0
 * @2012-11-27 ����11:25:01
 */
public enum ErrorCodeEnum {
	NULL("������", 1), CONNECT_FAIL("����ʧ��", 2), MESSAGE_EXCEPTION("�쳣����", 3);
	// ��Ա����  
    private String name;  
    private int index;  
    // ���췽��  
    private ErrorCodeEnum(String name, int index) {  
        this.name = name;  
        this.index = index;  
    }  
    // ��ͨ����  
    public static String getName(int index) {  
        for (ErrorCodeEnum c : ErrorCodeEnum.values()) {  
            if (c.getIndex() == index) {  
                return c.name;  
            }  
        }  
        return null;  
    } 
    
    // get set ����  
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
    public int getIndex() {  
        return index;  
    }  
    public void setIndex(int index) {  
        this.index = index;  
    }
}

