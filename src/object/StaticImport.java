/**
 * Program  : StaticImport.java
 * Author   : tanx
 * Create   : 2012-4-24 ����10:03:25
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

package object;
import static java.lang.Math.PI;  
/**
 * 
 * @author   tanx
 * @version  1.0.0
 * @2012-4-24 ����10:03:25
 */
public class StaticImport {
	 //����Բ���  
    public static double calCircleArea(double r){  
          return PI * r * r;  
    }    
    //���������  
    public static double calBallArea(double r){  
          return 4 * PI * r * r;  
    }  
}

