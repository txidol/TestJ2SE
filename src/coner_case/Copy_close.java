/**
 * Program  : Ca.java
 * Author   : tanx
 * Create   : 2012-8-20 ÏÂÎç3:01:06
 *
 * Copyright 2011 by iPanel.TV Inc.,
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of iPanel.TV Inc.("Confidential Information").  
 * You shall not disclose such Confidential Information and shall 
 * use it only in accordance with the terms of the license agreement 
 * you entered into with iPanel.TV Inc.
 *
 */

package coner_case;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 
 * @author   tanx
 * @version  1.0.0
 * @2012-8-20 ÏÂÎç3:01:06
 */
public class Copy_close {
	static void copy (String src ,String dest)throws IOException{
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(src);
			out = new FileOutputStream(dest);
			byte[] buf = new byte[1024];
			int n;
			while ((n = in.read(buf))>0) {
				out.write(buf, 0, n);
			}
			
		}finally{
			closeIgnoringException(in);
			closeIgnoringException(out);
		}
	}
	
	private static void closeIgnoringException(Closeable c){
		if(c != null){
			try {
				c.close();
			} catch (IOException e) {
				// TODO: handle exception
			}
		}
	}
}

