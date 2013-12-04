package reflect.factory;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestFactory {
	
	@Test
	public void test(){
		IFruit f = Factory.getInstance("apple");
		f.eat();
		assertEquals("apple", f.getEated());		
	}
	
	@Test
	public void testReflect(){
		IFruit f = Factory.getReflectInstance("Apple");
		f.eat();
		assertEquals("apple", f.getEated());		
	}
	
	
}
