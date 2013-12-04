package problem;

import java.io.File;

/**
 * Program  : problem.java
 * Author   : tanx
 * Create   : 2012-4-19 ионГ11:11:43
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

/**
 * 
 * @author   tanx
 * @version  1.0.0
 * @2012-4-19 ионГ11:11:43
 */
abstract class Problem {
	public  void test(){
//		double     a = 0;
//		switch(a){
//		
//		}
	}
	

	  static int arr[] = new int[5]; 
	    public static void main(String a[]) 
	    { 
	       	System.out.println(arr[0]); 
	       	
	       	String[] srt=new String[10];
	    	System.out.println(srt.length); 
	    	
	    	File sss = new File("D:/a.txt");
	    	if(sss.exists()){
	    		System.out.println("ss");
	    	}
	    	int count = 0;
	    	for(int x =0 ;x<=100/3;x++){
	    		for(int y =0 ;y<=50;y++){
		    		int z =100-(3*x + 2*y) ;
		    		if((x + y +2*z) == 100 ){
			    		System.out.println(x+"/" +y+"/"+2*z);
			    		count++;
			    	}
		    	}
	    	}
	    	System.out.println(count);
	    	
	    }
	    
	    public void testOk(){
	    	int count = 0;
	    	for(int x =0 ;x<=100/3;x++){
	    		for(int y =0 ;y<=50;y++){
		    		int z =100-(3*x + 2*y) ;
		    		if((x + y +2*z) == 100 ){
			    		System.out.println(x+"/" +y+"/"+2*z);
			    		count++;
			    	}
		    	}
	    	}
	    	System.out.println(count);
	    }
}

