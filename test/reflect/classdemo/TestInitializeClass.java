package reflect.classdemo;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestInitializeClass {
	
	@Test
	public void testGetClass(){
		String str = "HELLO";
		Class<?> cls = str.getClass();
		assertEquals("java.lang.String", cls.getName());
	}
	
	@Test
	public void testDotClass(){
		Class<?> cls = String.class;
		assertEquals("java.lang.String", cls.getName());
	}
	
	@Test
	public void testForName() throws ClassNotFoundException{
		Class<?> cls = Class.forName("java.lang.String");
		assertEquals(String.class,cls);
		assertEquals("java.lang.String", cls.getName());
	}
	
	@Test
	public void testBaseData() {
		
		Class<?> integer = int.class;
		assertNotNull(integer);
		assertTrue(integer.isPrimitive());
		assertEquals(Integer.TYPE,integer);
		assertEquals("java.lang.Integer",Integer.class.getName());
		
	
		int[] test = {1,1} ;		
		Class<?> array = test.getClass();
		assertNotNull(array);
		assertEquals(int[].class,array);
		assertTrue(array.isArray());
		
	}
}
