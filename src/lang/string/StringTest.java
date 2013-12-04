package lang.string;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringTest {

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
	for (int i = 0; i < id.length; i++) {
	    System.out.println(id[i]);
	}
    }

}
