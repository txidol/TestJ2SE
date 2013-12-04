/**
 * 功能：xml文件操作（写xml）
 */
package com.mopon.util.out;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

import java.io.File;

public class XmlUtil {
	

	
	/**
	 * 功能：写xml的通用函数。
	 * 参数：待写xlm的路径及文件名，字段名的list，各行数据的list
	 */
	public static void writeXMLFile(String outFile,List m_fieldsList, List m_rowsDataList) throws Exception
	{
		if(m_rowsDataList!=null && m_rowsDataList.size()>0){
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		    DocumentBuilder db = null;
		    try{
		    	db = dbf.newDocumentBuilder();
		    }
		    catch(Exception pce){
		    	 System.out.println(pce);
	        }
		    Document doc=db.newDocument();
		    //在doc中创建根节点
		    Element root=doc.createElement("ROOT");
		    doc.appendChild(root); 
		    List tmpList;
		    for(int i=0; i<m_rowsDataList.size(); i++){
		    	Element rowNode=doc.createElement("row");
		    	root.appendChild(rowNode);
		    	
		    	//取到各行数据的列表
		    	tmpList = (List)m_rowsDataList.get(i);
	   
		    	Element rowCell;
		    	for(int j=0; j<tmpList.size(); j++){ System.out.println("==writeXMLFile(),j="+j+",tmpList.get(j)="+tmpList.get(j));
			    	rowCell=doc.createElement("field");
			    	rowCell.setAttribute("name", m_fieldsList.get(j).toString());
			    	rowCell.appendChild(doc.createTextNode(tmpList.get(j).toString()));
			        rowNode.appendChild(rowCell);	
		    	}
		    }
		    //用xmlserializer把document的内容进行串化
		    FileOutputStream os=null;
		    try{
		    	OutputFormat outformat=new OutputFormat(doc);
		    	outformat.setIndenting(true);//启用缩进和换行
		     //outformat.setIndent(8);
		     //outformat.setLineSeparator("\n\r");
		     
		    	os=new FileOutputStream(outFile);//"output.xml"
		    	XMLSerializer xmlSerilizer=new XMLSerializer(os,outformat);
		    	xmlSerilizer.serialize(doc);
		    	os.close();
		    }
		    catch(Exception e)
		    {
			  e.printStackTrace();
		      System.out.println("create xml failed...\n");
		    }
		}
	}
	

	
	/**
	 * 功能：读取xml的通用函数。
	 * 参数：待读xlm的路径及文件名；
	 * 返回值：各行数据的list
	 */
	public static List readXML(String fileURI){
		List reList = new ArrayList();//各行数据的list
		List rowDataList = new ArrayList();//中间变量，xml中一行数据的list
		try{    
		    File f = new File(fileURI);    
		    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();    
		    DocumentBuilder builder = factory.newDocumentBuilder();    
		    Document doc = builder.parse(f);    
		    NodeList nodeListRows = doc.getElementsByTagName("row");    

		    for(int i = 0; i<nodeListRows.getLength(); i++) {  
		    	rowDataList = new ArrayList();
			    NodeList nodeListFields = ((Element)nodeListRows.item(i)).getElementsByTagName("field");    
			    for(int j=0; j<nodeListFields.getLength(); j++){
			    	//System.out.println("readXMLFile(),i="+i+",j="+j);
			    	//System.out.println("readXMLFile(),value="+nodeListFields.item(j).getFirstChild());
			    	//System.out.println("readXMLFile(),value="+nodeListFields.item(j).getFirstChild().getNodeValue());
			    	
			    	//if(nodeListFields.item(j).getNodeType()==Node.ELEMENT_NODE){
			    	if(nodeListFields.item(j).getFirstChild()!=null){
			    		//处理这样的结点的读取<field name="notice" /> 
			    		rowDataList.add(nodeListFields.item(j).getFirstChild().getNodeValue());
			    	}
			    	else{
			    		rowDataList.add("");
			    	}
			    }
			    reList.add(rowDataList);
		    }
	    } 
		catch (Exception e) {    
			e.printStackTrace();    
	    } 
		return reList;
	}
	public static  List<Map<String,String>> readXMLFile(String outFile){
		 DocumentBuilderFactory domfac=DocumentBuilderFactory.newInstance();
		 List<Map<String,String>> returnlist = new ArrayList<Map<String,String>>();
	       
	        try {
	            DocumentBuilder dombuilder=domfac.newDocumentBuilder();
	            InputStream is=new FileInputStream(outFile);
	            Document doc=dombuilder.parse(is);
	            NodeList nl =doc.getElementsByTagName("row");
	            for (int i=0;i<nl.getLength();i++){
	                Node node=nl.item(i);
	                NodeList fileds  = node.getChildNodes();
	                Map<String,String> map= new HashMap<String ,String>();
	                for(int j=0; j<fileds.getLength();j++){
	                	Node filed=fileds.item(j);
	                	
	                	if(filed.getNodeType()==Node.ELEMENT_NODE){
	                		map.put(filed.getAttributes().getNamedItem("name").getNodeValue(), filed.getFirstChild().getNodeValue());
	                	}
	                }
	                returnlist.add(map);
	             }
	      
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return returnlist;
		
	}
	

}
