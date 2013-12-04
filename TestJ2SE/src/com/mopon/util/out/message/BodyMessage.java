package com.mopon.util.out.message;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Title: 
 * Description: 
 * Company:mopon
 * Copyright:Copyright(c)2013
 * </p>
 * @date 2013年10月11日
 * @author 谭翔
 * @version 1.0
 */
public class BodyMessage {
    private String messageName;
    private Map<String, String> messageParams;
    
    public BodyMessage addMessageName(String paramName, String paramValue) {
        if(messageParams == null){
            messageParams = new HashMap<String, String>();
        }
        this.messageParams.put(paramName, paramValue);
	return this;
    }
    
    public String getMessageName() {
        return messageName;
    }
    public void setMessageName(String messageName) {
        this.messageName = messageName;
    }
    public Map<String, String> getMessageParams() {
        return messageParams;
    }
    public void setMessageParams(Map<String, String> messageParams) {
        this.messageParams = messageParams;
    }
    
    
}
