/**
 * Program  : MD5TEST.java
 * Author   : tanx
 * Create   : 2012-11-29 下午4:02:34
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
	
package md5;
import java.security.MessageDigest;
import sun.misc.BASE64Encoder;
/**
 * 
 * @author   tanx
 * @version  1.0.0
 * @2012-11-29 下午4:02:34
 */
public class EncodeByMd5 {



	     public static String MD5(String str){

	        //确定计算方法
	        String newstr = null;
	   try {
	    MessageDigest md5 = MessageDigest.getInstance("MD5");
	    BASE64Encoder base64en = new BASE64Encoder();
	      //加密后的字符串
	    newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
	      
	   } catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	   }
	   return newstr;
	    }

	public final static String encode(String s) { 
	    char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
	    'a', 'b', 'c', 'd', 'e', 'f' }; 
	    try { 
	     byte[] strTemp = s.getBytes(); 
	     //使用MD5创建MessageDigest对象 
	     MessageDigest mdTemp = MessageDigest.getInstance("MD5"); 
	     mdTemp.update(strTemp); 
	     byte[] md = mdTemp.digest(); 
	     int j = md.length; 
	     char str[] = new char[j * 2]; 
	     int k = 0; 
	     for (int i = 0; i < j; i++) { 
	      byte b = md[i]; 
	      //System.out.println((int)b); 
	      //将没个数(int)b进行双字节加密 
	      str[k++] = hexDigits[b >> 4 & 0xf]; 
	      str[k++] = hexDigits[b & 0xf]; 
	     } 
	     return new String(str); 
	    } catch (Exception e) {return null;} 
	   }

	public static void main(String[] args){
	   //System.out.println(EncodeByMd5.encode("jiangmy"));
	   System.out.println(EncodeByMd5.encode("56gg"));
	   //System.out.println(EncodeByMd5.encode("")+"----d41d8cd98f00b204e9800998ecf8427e");
	   
	   System.out.println(EncodeByMd5.encode("72e76d88367d35f97c48d5027e4da6fb"));
	}
	
}

