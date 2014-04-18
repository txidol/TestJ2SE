package com.mopon.util.out;
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
public class ExtendUnCheckException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5419771093000221587L;
	private String errorCode;

	public ExtendUnCheckException() {
		super();
	}	
	public ExtendUnCheckException(Throwable t) {
		super(t);
	}
	public ExtendUnCheckException(String s) {
		super(s);
	}

	public  ExtendUnCheckException(String errcode,String errmsg){
		super(errmsg);
		setErrorCode(errcode);
	}
	
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

}
