package reflect.classdemo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestOperatePerson {
	static Class<?> cls ;
	
	@BeforeClass	
	public static void init() throws ClassNotFoundException{
		cls =  Class.forName("reflect.classdemo.Person");
	}
	
	@Test
	public void testMethod() throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException{
		Method m = cls.getMethod("sayHello");
		Object result = m.invoke( cls.newInstance() );	
		assertEquals("hello", result);	
		
		Method m1 = cls.getMethod("say",String.class,int.class);
		Object result1 = m1.invoke( cls.newInstance() , "tan" , 24 );	
		assertEquals("tan 24", result1);	
	}
	
	@Test
	public void testGetOrSet() throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException{
		
		Object o = cls.newInstance();
		set(o,"name","tanx",String.class);
		set(o,"age",24,int.class);
		assertEquals("tanx", get(o,"name"));	
		assertEquals(24, get(o,"age"));	
	}
	
	@Test
	public void testField() throws InstantiationException, IllegalAccessException, SecurityException, NoSuchFieldException{
		
		Object o = cls.newInstance();
		Field name = o.getClass().getDeclaredField("name");
		Field age = o.getClass().getDeclaredField("age");
		
		name.setAccessible(true);
		age.setAccessible(true);
		
		name.set(o, "tanx");
		age.set(o, 24);
		
		assertEquals("tanx", name.get(o));	
		assertEquals(24, age.get(o));
		
	}
	
	public void set(Object o ,String name ,Object object ,Class<?> valtype ) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException{
		Method m = o.getClass().getMethod("set" + upperHead(name) , valtype);
		m.invoke(o, object);
	}
	
	public Object get(Object o ,String name  ) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException{
		Method m = o.getClass().getMethod("get" + upperHead(name) );
		return m.invoke(o);
	}	
	
	public String upperHead(String name){
		return name.substring(0, 1).toUpperCase() + name.substring(1);		
	}
	
	
}
