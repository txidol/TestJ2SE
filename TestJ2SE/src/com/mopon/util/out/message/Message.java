package com.mopon.util.out.message;

import java.util.ArrayList;
import java.util.List;


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
public class Message {
    private HeaderMessage headerMessage;
    private List<Object> bodyMessages;
    
    public Message(HeaderMessage headerMessage) {
	super();
    }
    
    public Message addHeaderMessage(HeaderMessage headerMessage) {
	this.setHeaderMessage(headerMessage);
	return this;
    }
    
    public Message addBodeyMessages(Object bodyMessages) {
	if(this.getBodyMessages() == null){
	    this.setBodyMessages(new ArrayList<Object>());
	}	
	this.getBodyMessages().add(bodyMessages);
	return this;
    }
    
    public Message(HeaderMessage headerMessage, List<Object> bodyMessages) {
	super();
	this.headerMessage = headerMessage;
	this.bodyMessages = bodyMessages;
    }
    
    public HeaderMessage getHeaderMessage() {
        return headerMessage;
    }
    public void setHeaderMessage(HeaderMessage headerMessage) {
        this.headerMessage = headerMessage;
    }
    public List<Object> getBodyMessages() {
        return bodyMessages;
    }
    public void setBodyMessages(List<Object> bodyMessages) {
        this.bodyMessages = bodyMessages;
    }
        
}
