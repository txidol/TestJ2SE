package com.mopon.util.out.message;
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
public class HeaderMessage {
    
    private String transactionId;
    private String version;
    private String timestamp;
    private String tradeId;
    private String msgType;
    private String signature;
    
    public String getTransactionId() {
        return transactionId;
    }
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
    public String getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    public String getTradeId() {
        return tradeId;
    }
    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }
    public String getMsgType() {
        return msgType;
    }
    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
    public String getSignature() {
        return signature;
    }
    public void setSignature(String signature) {
        this.signature = signature;
    }    
}
