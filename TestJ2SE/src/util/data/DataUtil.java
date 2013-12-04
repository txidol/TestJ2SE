package util.data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DataUtil {
    /**  
     * 格式化string为Date  
     * @param datestr  
     * @return date  
     */  
    public static Date parseDate(String datestr) {   
        if (null == datestr || "".equals(datestr)) {   
            return null;   
        }   
        try {   
            String fmtstr = null;   
            if (datestr.indexOf(':') > 0) {   
                fmtstr = "yyyy-MM-dd HH:mm:ss";   
            } else {   
  
                fmtstr = "yyyy-MM-dd";   
            }   
            SimpleDateFormat sdf = new SimpleDateFormat(fmtstr, Locale.UK);   
            return sdf.parse(datestr);   
        } catch (Exception e) {   
            return null;   
        }   
    }   
  
    /**  
     * 日期转化为String  
     * @param date  
     * @return date string  
     */  
    public static String fmtDate(Date date) {   
        if (null == date) {   
            return null;   
        }   
        try {   
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",   
                    Locale.US);   
            return sdf.format(date);   
        } catch (Exception e) {   
            return null;   
        }   
    }   
}
