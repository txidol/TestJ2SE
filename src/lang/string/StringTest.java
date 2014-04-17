package lang.string;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringTest {

	@Test
	public void testEquels(){
		String test = "12345";
		String test1 = "12345";
		String test2 = new String("12345");
		String test3 = new String("12345");
		
		String t1 = test;
		String t2 = "12"+"345";
		
		assertTrue(test==test1);
		assertTrue(test==t1);
		assertTrue(test==t2);
		
		assertTrue(test!=test2);
		assertTrue(test2!=test3);		
	}
	
	@Test
	public void testNotChange(){
		String inString = "123";		
		String outString = 	stubChangeString(inString);
		
		assertEquals("123", inString);
		assertEquals("123test", outString);
	}
	
	private String stubChangeString(String inString){
		inString += "test";
		return inString;
	}
	
	@Test
	public void testSubString() {
		String test = "12345";
		assertEquals("2345", test.substring(1));
	}

	@Test
	public void testToArrays() {
		List<String> ids = new ArrayList<>();
		ids.add("1");
		ids.add("2");
		ids.add("3");
		String[] id = ids.toArray(new String[0]);
		assertEquals(3, id.length);
		assertEquals("1", id[0]);
	}

}
