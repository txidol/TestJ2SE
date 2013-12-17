package xml;

import static javax.xml.bind.JAXB.*;

import java.io.File;
import java.io.UnsupportedEncodingException;


/**
 * <p>Copyright:Copyright(c)2013</p>
 * <p>Company:Mopon</p>
 * <p>Description: </p>
 * @date 2013年12月17日
 * @author 谭翔
 * @version 1.0
 */
public class MainTest {
	public static void main(String[] args) throws UnsupportedEncodingException {
		Point p = new Point();
		p.setX(1);
		p.setY(3);
		//System.out.println(new String("中文".getBytes("utf-8"), "utf-8"));
		//p.setName(new String("中文".getBytes("utf-8"), "utf-8"));
		p.setName("中文");
		
		marshal(p, System.out);
		File f = new File("C://Users//tanx//git//TestJ2SE//src//xml//test.xml");
		if (f.exists()) {
			System.out.println("yes");
			marshal(p, f);
		}
		
		Point p2 = unmarshal(f, Point.class); 
		System.out.println(p2); 
		
	}
}
