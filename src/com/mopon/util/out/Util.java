/**
 * Copy Right Information   : Forsoft 
 * Project                  : cuss
 * JDK version used         : jdk1.5
 * Comments                 : 框架使用的一些公共操作
 * Version                  : 1.0
 * create date              : 2008.5.20
 * author                   ：ShiLiangShuai
 */
package com.mopon.util.out;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;



public class Util {
	public final static SimpleDateFormat sdfTime = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	public final static SimpleDateFormat sdfDate = new SimpleDateFormat(
			"yyyy-MM-dd");
	public final static SimpleDateFormat sdfDate_8b = new SimpleDateFormat(
			"yyyyMMdd");
	public final static SimpleDateFormat sdfTime_14b = new SimpleDateFormat(
			"yyyyMMddHHmmss");
	public static Timer timer = new Timer(false);
	public static String nowDate() {
		return sdfDate.format(new Date());
	}

	public static String nowDate_8b() {
		return sdfDate_8b.format(new Date());
	}

	public static String nowTime() {
		return sdfTime.format(new Date());
	}

	public static String nowTime_14b() {
		return sdfTime_14b.format(new Date());
	}


	
	/**为对象加入'' 组成'对象'形式,如果是null则返回null
	 * param:value:具体条件,type:F表示前面加%,B表示后面加,ALL表示前后都加
	 * return:包装后的字符串
	 * */
	public static String toSqlValLike(Object value,String type){
		if(value == null){
			return null;
		}else{
			if(type.equals("F")){
		
				return "'%" + value.toString() + "'";
			}else if(type.equals("B")){
				return "'" + value.toString() + "%'";
			}else if(type.equals("ALL")){
				return "'%" + value.toString() + "%'";
				
			}
			return "";
		}
	}
	
	/**判断对象是否可以做为sql的查询条件
	 * param:Object
	 * return:是或者否
	 * */
	public static boolean isCon(Object obj){
		if(obj != null && !obj.toString().equals("") && !obj.toString().equals("null")){
			return Boolean.TRUE;
		}else{
			return Boolean.FALSE;
		}
	}
	

	/**判断对象是否可以做为sql的查询条件
	 * param:Object
	 * return:是或者否
	 * */
	public static String concatLike(String str,String style){
		if(isCon(str)){
			if("before".equals(style)){
				str = "%" + str;
			}else if("after".equals(style)){
				str += "%";
			}else if("all".equals(style)){
				str = "%" + str + "%" ;
			}
		}else{
			return "";
		}
		
		return str;
	}
	

	





	
	/**
	 * datestr 为yyyy-MM-dd 格式的日期字符串      
	 * bforafnum 为之后或之前的月数  如果是之前  就传负数
	 * 返回规定时间   之前或之后规定月数  的时间  也返回yyyy-MM-dd 格式的字符串
	 */
	public static String dateBfOrAfTime(String datestr,int bforafnum) {
		String reStr="";
		try {
			Date now  = sdfDate.parse(datestr);
			 Calendar ca = Calendar.getInstance();
				ca.setTime(now);
				ca.add(Calendar.MONTH, bforafnum);
				reStr = sdfDate.format(ca.getTime());
		} catch (Exception e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
		return reStr;
	}

	public static boolean isNumeric(String str){
		for (int i = str.length();--i>=0;){
			  if (!Character.isDigit(str.charAt(i))){
				  return false;
			  }
		}
		return true;
	}
	
	public static JSONArray asListMap(String[] sp){
		JSONArray li = new JSONArray();
		for(int i = 0; i<sp.length; i++){
			JSONObject js = new JSONObject();
			js.element("code_id", sp[i]);
			js.element("code_name", sp[i]);
			li.add(js);
		}
		return li;
	}
	
	/**
	 * 按指定的截取符截取0到indexOf(cStr)字符串
	 * @param sStr	源字符串
	 * @param cStr	截取符
	 * @return
	 */
	public static String cutStr(String sStr, String cStr){
		int index = sStr.indexOf(cStr);
		if(index != -1){
			sStr = sStr.substring(0,index);
		}
		return sStr;
	}
	
	public static String getEnv(){
		String pathValue = "";
		String osName = System.getProperty("os.name");
		if (osName.matches("^(?i)Windows.*$")){
			pathValue = getRootPathForWindows();
			//处理路径含%20的问题，恢复原空格
			//Log logger = LogFactory.getLog(Util.class);
			try{
				pathValue = java.net.URLDecoder.decode(pathValue,"utf-8"); 
			}catch(Exception e){
				//logger.info("[常量类信息]：  路径转换异常",e);
				
				
			}
		}else{
			pathValue = getRootPathForLinux();
		}
		return pathValue;
	}	

	private static String getRootPathForWindows() {
		String result = Util.class.getResource("Util.class").toString();
		int index = result.indexOf("WEB-INF");
		if (index == -1) {
			index = result.indexOf("bin");
		}
		result = result.substring(0, index);
		if (result.startsWith("jar")) {
			// 当class文件在jar文件中时，返回"jar:file:/F:/ ..."样的路径 
			result = result.substring(10);
		} else if (result.startsWith("file")) {
			// 当class文件在class文件中时，返回"file:/F:/ ..."样的路径 
			result = result.substring(6);
		}
		if (result.endsWith("/"))
			result = result.substring(0, result.length() - 1);
		return result;
	}

	private static String getRootPathForLinux() {
		String result = Util.class.getResource("Util.class").toString();
		int index = result.indexOf("WEB-INF");
		if (index == -1) {
			index = result.indexOf("bin");
		}
		result = result.substring(0, index);
		if (result.startsWith("jar")) {
			// 当class文件在jar文件中时，返回"jar:file:/usr/local/"样的路径 
			result = result.substring(9);
		} else if (result.startsWith("file")) {
			// 当class文件在class文件中时，返回"file:/usr/local/"样的路径 
			result = result.substring(5);
		}
		if (result.endsWith("/"))
			result = result.substring(0, result.length() - 1);
		return result;
	}
	 
}
