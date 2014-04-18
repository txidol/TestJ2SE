/**
 * Copy Right Information   : Forsoft 
 * Project                  : ICS
 * JDK version used         : jdk1.6
 * Comments                 : 读取配置文件XML信息
 * Version                  : 1.0
 * create date              : 2008.4.15
 * author                   ：
*/
package com.mopon.util.out;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;


public abstract class OperateXML {

	private static final String CONFIG_FILE = "/config.xml"; //配置文件名
	private static DocumentBuilder builder;
	private static Document config;
	static {
		try {
			builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			config = builder.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream(CONFIG_FILE));
		} catch (Exception e) {	
			
			throw new ExtendUnCheckException("OperateXML 初始化失败"); 
		}
	}

	public OperateXML() {
		super();
	}	
	
	/**
	 * Description :读取配置文件config.xml标签为<page>的信息装载到Map中。
	 *              属性name的值作为Map的key;PageInfo对象实例作为value。
	 * @return Map
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map readxml(){
		Element root = config.getDocumentElement();
		NodeList nl = root.getElementsByTagName("page");
		Map map = new HashMap();			
		try {
			for (int i = 0; i < nl.getLength(); i++) {
				Element element = (Element) nl.item(i);
				map.put(element.getAttribute("name"),setDTOValue((PageInfo.class).getName(),element));				
			}			
			return map;
		} catch (Exception e) {			
			throw new ExtendUnCheckException("readxml读取配置文件失败");
		}
	}
	
	/**
	 * Description :读取配置文件config.xml标签为<page>的信息装载到Map中。
	 *              属性name的值作为Map的key。
	 * @param str: 类名称（PageInfo）,用来生成一个实例。
	 * @param str: element对象
	 * @return Object
	 */
	protected static Object setDTOValue(String str,Element element){			
		Object obj = null;
		try {			 
			obj = Class.forName(str).newInstance();			 
			NodeList nl = element.getChildNodes();				
			for(int i = 0; i < nl.getLength(); i++){
				Node node = nl.item(i);					
				if(node.getNodeType() == Node.ELEMENT_NODE){
					if(node.getFirstChild() == null){
						setDTOPropertyValue(node.getNodeName(),ConstantClass.PAGE_DEFAULT_VALUE,obj);
					}else{
						setDTOPropertyValue(node.getNodeName(),node.getFirstChild().getNodeValue(),obj);
					}
				}
			}			 
			return obj;
		} catch (Exception e) {
			throw new ExtendUnCheckException("读取配置文件失败");			
		}
	}
	
	/**
	 * Description :用java类反射给类对象属性赋值
	 * @param str: 类中的属性名
	 * @param str: 属性对象要赋予的值
	 * @param str: 类对象实例
	 */
	private static void  setDTOPropertyValue(String str,String value,Object obj) {		
		try{
			Method m = obj.getClass().getMethod(pickSetMethordName(str),new Class[]{String.class});
			
		 	if(m != null){
		 		m.invoke(obj,new Object[]{value});			 	
			}				
	 	}catch(Exception e){	 		
			throw new ExtendUnCheckException("读取配置文件失败");
	 	}	
	}
	
	/**
	 * Description :生成属性对应get方法名
	 * @param str: 类中的属性名
	 * @return String
	 */
	@SuppressWarnings("unused")
	private static String pickGetMethordName(String str){
		str = "get" + str.substring(0,1).toUpperCase() + (str.toLowerCase()).substring(1,str.length());
		return str;
	}
	
	/**
	 * Description :生成属性对应set方法名
	 * @param str: 类中的属性名
	 * @return String
	 */
	private static String pickSetMethordName(String str){		
		str = "set" + str.substring(0,1).toUpperCase() + (str.toLowerCase()).substring(1,str.length());		
	 	return str;
	}
	
	/**
	 * Description :读取配置文件config.xml标签为<sclist>的信息装载到Map中。
	 *              属性name的值作为Map的key;SclistInfo对象实例作为value。
	 * @return Map
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map readxml_sclist(){
		Element root = config.getDocumentElement();
		NodeList nl = root.getElementsByTagName("sclist");	
		int size = nl.getLength();
		
		Map map = new HashMap();
		try {
			for (int i = 0; i < size; i++){
				Element element = (Element)nl.item(i); 
				map.put(element.getAttribute("name"),SetDTOValue_sclist((SclistInfo.class).getName(),element));
			}			
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExtendUnCheckException("readxml_sclist读取配置文件失败");
		}
	}
	
	/**
	 * Description :给SclistInfo实例赋值
	 * @param str : 类名（即SclistInfo）
	 * @param element : 元素实例, 一个list
	 * @return SclistInfo实例,SclistInfo中的sclist属性装载的是Sclist_DATA实例
	 */
	protected static Object SetDTOValue_sclist(String str, Element element){
		Object obj = null;
		try {			 
			obj = Class.forName(str).newInstance();
			NodeList nl = element.getElementsByTagName("record");

		   	for(int i = 0; i < nl.getLength(); i++){
		   		SclistDATA dto = new SclistDATA();
		   		Element elRcd = (Element)nl.item(i);
		   		
		   		//获取id
		   		NodeList nlId = elRcd.getElementsByTagName("id");
		   		Element elId = (Element)nlId.item(0);     
		   		Text tID = (Text)elId.getFirstChild();     
		   		dto.setId(tID.getNodeValue());
		   		//获取name
		   		NodeList nlName = elRcd.getElementsByTagName("name");
		   		Element elName = (Element)nlName.item(0);     
		   		Text tName = (Text)elName.getFirstChild();     
		   		dto.setName(tName.getNodeValue());
		   		
		   		//((SclistInfo)obj).getSclist().add(dto);
			}
			return obj;
		}
		catch (Exception e){
			e.printStackTrace();
			throw new ExtendUnCheckException("SetDTOValue_sclist读取配置文件失败");
		}
	}
	
	public static Map<String, String> readxml_path(){
		Element root = config.getDocumentElement();
		NodeList nl = root.getElementsByTagName("path");
		
		Map<String, String> map = new HashMap<String, String>();			
		try {
			for (int i = 0; i < nl.getLength(); i++) {
				Element element1 = (Element) nl.item(i);
				map.put(element1.getAttribute("name"),element1.getAttribute("parameter"));
			}			
			return map;
		} catch (Exception e) {			
			throw new ExtendUnCheckException("readxml_path读取配置文件失败");
		}
	}
	
	public static void main(String[] args) throws Exception{
		readxml();
	}
	
}
