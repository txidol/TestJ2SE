package xml;

import static javax.xml.bind.JAXB.*;
import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;


/**
 * <p>Copyright:Copyright(c)2013</p>
 * <p>Company:Mopon</p>
 * <p>Description: </p>
 * @date 2013��12��17��
 * @author ̷��
 * @version 1.0
 */
public class PointTest {
	
	@Test
	public void test() throws Exception{
		Point p = new Point();
		p.setX(1);
		p.setY(3);	
		p.setName("����");
		
		marshal(p, System.out);
		File f = new File("C://Users//tanx//git//TestJ2SE//src//xml//test.xml");
		if (f.exists()) {
			System.out.println("yes");
			marshal(p, f);
		}
		
		Point p2 = unmarshal(f, Point.class); 
		System.out.println(p2); 
		
		assertEquals(p, p2);
	}
}
