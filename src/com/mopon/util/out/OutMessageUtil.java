package com.mopon.util.out;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.mopon.util.out.message.AreaMessage;
import com.mopon.util.out.message.BodyMessage;
import com.mopon.util.out.message.HeaderMessage;
import com.mopon.util.out.message.Message;

/**
 * <p>
 * Title: 对外服务消息处理帮助类 Description: Company:mopon Copyright:Copyright(c)2013
 * </p>
 * 
 * @date 2013年10月11日
 * @author 谭翔
 * @version 1.0
 */

public class OutMessageUtil {

    /**
     * 方法用途: <br>
     * 实现步骤: <br>
     * 
     * @param xml
     *            String
     * @return
     * @throws DocumentException
     */
    public Object parseMessage(String xml) throws DocumentException {
	ByteArrayInputStream stream = new ByteArrayInputStream(xml.getBytes());
	return parseMessage(stream);
    }

    /**
     * 方法用途: <br>
     * 实现步骤: <br>
     * 
     * @param xml
     *            InputStream
     * @return
     * @throws DocumentException
     */
    public Object parseMessage(InputStream xml) throws DocumentException {
	SAXReader reader = new SAXReader();
	Document doc = reader.read(xml);
	Element root = doc.getRootElement();
	// readNode(root, "");
	Message message = read(root);
	return null;
    }

    @SuppressWarnings("unchecked")
    public  Message read(Element root) {
	if (root == null)
	return null;
	List<Element> childNodes = root.elements();	
	HeaderMessage header = new HeaderMessage();
	List<Object> bodys = new ArrayList<Object>();
	for (Element e : childNodes) {
	    if ("header".equals(e.getName())) {
		List<Element> headerMessages = e.elements();
		for (Element headerMessage : headerMessages) {
		    setBeanValue(headerMessage.getName(),
			    headerMessage.getText(), header);
		}
	    }
	    if ("body".equals(e.getName())) {
		List<Element> bodyMessages = e.elements();
		for (Element bodyMessage : bodyMessages) {
		    Object obj = null;
		    try {
			String prefix = "com.mopon.service.app.out.message.";
			obj = Class.forName(prefix + bodyMessage.getName())
				.newInstance();

		    } catch (InstantiationException | IllegalAccessException
			    | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		    }
		   
		    Map<String, String> valMap = new HashMap<String, String>();
		    List<Element> messages = bodyMessage.elements();
		    for (Element message : messages) {			
			valMap.put(message.getName(), message.getText());
		    }		    
		    setFieldValue(obj,valMap);
		    bodys.add(obj);
		}
	    }
	}
	Message massage = new Message(header,bodys);

	return massage;
    }

    /**
     * Description :用java类反射给类对象属性赋值
     * 
     * @param str
     *            : 类中的属性名
     * @param str
     *            : 属性对象要赋予的值
     * @param str
     *            : 类对象实例
     */
    private static void setBeanValue(String str, String value, Object obj) {
	Method m = null;
	try {
	    m = obj.getClass().getMethod(parSetName(str),
		    new Class[] { String.class });

	} catch (Exception e) {
	    throw new ExtendUnCheckException("读取配置文件失败");
	}

	if (m != null) {
	    try {
		m.invoke(obj, new Object[] { value });
	    } catch (IllegalAccessException | IllegalArgumentException
		    | InvocationTargetException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
    }



    public static void setFieldValue(Object bean, Map<String, String> valMap) {
	Class<?> cls = bean.getClass();
	// 取出bean里的所有方法
	Method[] methods = cls.getDeclaredMethods();
	Field[] fields = cls.getDeclaredFields();

	for (Field field : fields) {
	    try {

		String fieldSetName = parSetName(field.getName());
		if (!checkSetMet(methods, fieldSetName)) {
		    continue;
		}
		Method fieldSetMet = cls.getMethod(fieldSetName,
			field.getType());
		String value = valMap.get(field.getName());
		if (null != value && !"".equals(value)) {
		    String fieldType = field.getType().getSimpleName();
		    if ("String".equals(fieldType)) {
			fieldSetMet.invoke(bean, value);
		    } else if ("Date".equals(fieldType)) {
			Date temp = parseDate(value);
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
     * 判断是否存在某属性的 set方法
     * 
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
     * 拼接在某属性的 set方法
     * 
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

    /**
     * 方法用途: <br>
     * 实现步骤: <br>
     * 
     * @param o
     * @return
     */
    public String generateMessage(Object o) {

	return "";
    }

    /**
     * 方法用途: <br>
     * 实现步骤: <br>
     * 
     * @param time
     * @return
     */
    public Date parseTime(String time) {

	return null;
    }

    /**
     * 方法用途: <br>
     * 实现步骤: <br>
     * 
     * @return
     */
    public String generateTime() {

	return "";
    }

}
