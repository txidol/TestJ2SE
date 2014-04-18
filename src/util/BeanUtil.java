package util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import util.data.DataUtil;

public class BeanUtil {
	
	
    /**  
     * rsת����bean
     * @param fieldName  
     * @return String  
     */ 
	public static Object rs2bean( ResultSet rs,Object bean) {

		try {
			// long start = 0;
			// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd
			// HH:mm:ss.SSS");
			// System.out.println(sdf.format(new Date()));
			// System.out.println(start = System.currentTimeMillis());
			ResultSetMetaData rsmd;
			rsmd = rs.getMetaData();
			int ColumnCount = rsmd.getColumnCount();
	
			// System.out.println(sdf.format(new Date()));
			// System.out.println(System.currentTimeMillis() - start);
			for (int i = 1; i <= ColumnCount; i++) {
				//2012-2-25 modify by jl mysqlͨ���÷������ܻ�ñ���
				String cName = rsmd.getColumnLabel(i);
				//cName = cName.toLowerCase();
				//Log.log(rsmd.getColumnLabel(i));
				BeanInfo info = Introspector.getBeanInfo(bean.getClass());
				PropertyDescriptor[] pds = info.getPropertyDescriptors();
				boolean propHascName = false;
				for (int j = 0; j < pds.length; j++) {
					if (pds[j].getDisplayName().equals(cName)) {
						propHascName = true;
						if (pds[j].getPropertyType().equals(String.class)) {
							pds[j].getWriteMethod().invoke(bean,
									new Object[] { rs.getString(cName) });
							break;
						} else if (pds[j].getPropertyType().equals(Date.class)) {
							pds[j].getWriteMethod().invoke(bean,
									new Object[] { rs.getDate(cName) });
							break;
						} else if (pds[j].getPropertyType().equals(int.class)) {
							pds[j].getWriteMethod().invoke(bean,
									new Object[] { rs.getInt(cName) });
							break;
						} else if (pds[j].getPropertyType().equals(double.class)) {
							pds[j].getWriteMethod().invoke(bean,
									new Object[] { rs.getDouble(cName) });
							break;
						} else if (pds[j].getPropertyType().equals(float.class)) {
							pds[j].getWriteMethod().invoke(bean,
									new Object[] { rs.getFloat(cName) });
							break;
						} else if (pds[j].getPropertyType().equals(boolean.class)) {
							pds[j].getWriteMethod().invoke(bean,
									new Object[] { rs.getBoolean(cName) });
							break;
						} else if (pds[j].getPropertyType().equals(Integer.class)) {
							pds[j].getWriteMethod().invoke(bean,
									new Object[] { rs.getInt(cName) });
							break;
						} else if (pds[j].getPropertyType().equals(Double.class)) {
							pds[j].getWriteMethod().invoke(bean,
									new Object[] { rs.getDouble(cName) });
							break;
						} else if (pds[j].getPropertyType().equals(Float.class)) {
							pds[j].getWriteMethod().invoke(bean,
									new Object[] { rs.getFloat(cName) });
							break;
						} else if (pds[j].getPropertyType().equals(Boolean.class)) {
							pds[j].getWriteMethod().invoke(bean,
									new Object[] { rs.getBoolean(cName) });
							break;
						} else {
//							Log.log("ERROR:����:"
//								+ cName
//								+ "������:"
//								+ pds[j].getPropertyType()+"���ҵ���ͬ���ģ���û��ƥ������͡�ERROR :Can't find the property's type of bean.");

							break;
						}
					}
				}
				if(false==propHascName)
				{
					if(!cName.equals("sls_rownum"))
					{
//					Log.log("ERROR:������"+cName+"û���ҵ���Ӧ��������.columnName not find equal propName");
					}
				}
				// System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
//			throw new ExtendUnCheckException(e);
		}
		return bean;
	}
	
	 /**  
     * rsת����json
     * @param fieldName  
     * @return String  
     */ 
	public static Object rs2json( ResultSet rs,Object json) {
		try {
			ResultSetMetaData rsmd;
			rsmd = rs.getMetaData();
			int ColumnCount = rsmd.getColumnCount();
			for (int i = 1; i <= ColumnCount; i++) {
				//2012-2-25 modify by jl mysqlͨ���÷������ܻ�ñ���
				String cName = rsmd.getColumnLabel(i);
				//cName = cName.toLowerCase();
				((net.sf.json.JSONObject)json).element(cName, rs.getString(cName)==null?"":rs.getString(cName));
				
			}
		} catch (Exception e) {
			e.printStackTrace();			
		}
		return json;
	}
	
	/**  
	 * ȡBean�����Ժ�ֵ��Ӧ��ϵ��MAP  
	 * @param bean  
	 * @return Map  
	 */  
	public static Map<String, String> getFieldValueMap(Object bean) {   
		Class<?> cls = bean.getClass();   
		Map<String, String> valueMap = new HashMap<String, String>();   
		// ȡ��bean������з���   
		Method[] methods = cls.getDeclaredMethods();   
		Field[] fields = cls.getDeclaredFields();   

        for (Field field : fields) {   
            try {   
                String fieldType = field.getType().getSimpleName();   
                String fieldGetName = parGetName(field.getName());   
                if (!checkGetMet(methods, fieldGetName)) {   
                    continue;   
                }   
                Method fieldGetMet = cls.getMethod(fieldGetName, new Class[] {});   
                Object fieldVal = fieldGetMet.invoke(bean, new Object[] {});   
                String result = null;   
                if ("Date".equals(fieldType)) {   
                    result = DataUtil.fmtDate((Date) fieldVal);   
                } else {   
                    if (null != fieldVal) {   
                        result = String.valueOf(fieldVal);   
                   }   
               }   
               valueMap.put(field.getName(), result);   
           } catch (Exception e) {   
               continue;   
            }   
       }   
        return valueMap;   
  
   }   
 
   /**  
     * set���Ե�ֵ��Bean  
     * @param bean  
     * @param valMap  
     */  
    public static void setFieldValue(Object bean, Map<String, String> valMap) {   
        Class<?> cls = bean.getClass();   
        // ȡ��bean������з���   
        Method[] methods = cls.getDeclaredMethods();   
        Field[] fields = cls.getDeclaredFields();   
  
        for (Field field : fields) {   
            try {   
  
                String fieldSetName = parSetName(field.getName());   
                if (!checkSetMet(methods, fieldSetName)) {   
                    continue;   
                }   
                Method fieldSetMet = cls.getMethod(fieldSetName, field   
                        .getType());   
                String value = valMap.get(field.getName());   
                if (null != value && !"".equals(value)) {   
                    String fieldType = field.getType().getSimpleName();   
                    if ("String".equals(fieldType)) {   
                        fieldSetMet.invoke(bean, value);   
                    } else if ("Date".equals(fieldType)) {   
                        Date temp = DataUtil.parseDate(value);   
                        fieldSetMet.invoke(bean, temp);   
                    } else if ("Integer".equals(fieldType)   
                            || "int".equals(fieldType)) {   
                        Integer intval = Integer.parseInt(value);   
                        fieldSetMet.invoke(bean, intval);   
                    } else if ("Long".equalsIgnoreCase(fieldType)) {   
                        Long temp = Long.parseLong(value);   
                        fieldSetMet.invoke(bean, temp);   
                    } else if ("Double".equalsIgnoreCase(fieldType)) {   
                        Double temp = Double.parseDouble(value);   
                        fieldSetMet.invoke(bean, temp);   
                    } else if ("Boolean".equalsIgnoreCase(fieldType)) {   
                        Boolean temp = Boolean.parseBoolean(value);   
                        fieldSetMet.invoke(bean, temp);   
                    } else {   
                        System.out.println("not supper type" + fieldType);   
                    }   
                }   
            } catch (Exception e) {   
                continue;   
            }   
        }   
  
    }   
  
  
    /**  
     * �ж��Ƿ����ĳ���Ե� set����  
     * @param methods  
     * @param fieldSetMet  
     * @return boolean  
     */  
    public static boolean checkSetMet(Method[] methods, String fieldSetMet) {   
        for (Method met : methods) {   
            if (fieldSetMet.equals(met.getName())) {   
                return true;   
            }   
        }   
        return false;   
    }   
  
    /**  
     * �ж��Ƿ����ĳ���Ե� get����  
     * @param methods  
     * @param fieldGetMet  
     * @return boolean  
     */  
    public static boolean checkGetMet(Method[] methods, String fieldGetMet) {   
        for (Method met : methods) {   
            if (fieldGetMet.equals(met.getName())) {   
                return true;   
            }   
        }   
        return false;   
    }   
  
    /**  
     * ƴ��ĳ���Ե� get����  
     * @param fieldName  
     * @return String  
     */  
    public static String parGetName(String fieldName) {   
        if (null == fieldName || "".equals(fieldName)) {   
            return null;   
        }   
        return "get" + fieldName.substring(0, 1).toUpperCase()   
                + fieldName.substring(1);   
    }   
  
    /**  
     * ƴ����ĳ���Ե� set����  
     * @param fieldName  
     * @return String  
     */  
    public static String parSetName(String fieldName) {   
        if (null == fieldName || "".equals(fieldName)) {   
            return null;   
        }   
        return "set" + fieldName.substring(0, 1).toUpperCase()   
                + fieldName.substring(1);   
    }   
}
