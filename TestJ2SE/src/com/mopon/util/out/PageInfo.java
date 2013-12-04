/**
 * Copy Right Information   : Forsoft 
 * Project                  : ICS
 * JDK version used         : jdk1.6
 * Comments                 : 页面翻页信息类
 * Version                  : 1.0
 * create date              : 2008.4.08
 * author                   ：
 * Modified By              : ghc
*/
package com.mopon.util.out;

public class PageInfo {
	
	private String key;
	private String start;
	private String perpagenum;
	private String paginationnum;

	public String getPerpagenum() {
		return perpagenum;
	}

	public void setPerpagenum(String perpagenum) {
		this.perpagenum = perpagenum;
	}

	public String getPaginationnum() {
		return paginationnum;
	}

	public void setPaginationnum(String paginationnum) {
		this.paginationnum = paginationnum;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String string) {
		start = string;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String string) {
		key = string;
	}

}
