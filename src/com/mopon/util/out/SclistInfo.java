/**
 * Copy Right Information   : Forsoft 
 * Project                  : ICS
 * JDK version used         : jdk1.6
 * Comments                 : 标准编码 standard code list 信息类
 * Version                  : 1.0
 * create date              : 2008.4.15
 * author                   : wangjun
 * modity                   : 
*/
package com.mopon.util.out;

import java.util.ArrayList;

public class SclistInfo 
{
	private String key = ""; //标准编码list名
	private ArrayList<?> sclist = new ArrayList<Object>(); //标准编码list值
	

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public ArrayList<?> getSclist() {
		return sclist;
	}

	public void setSclist(ArrayList<?> sclist) {
		this.sclist = sclist;
	}	
	
}
