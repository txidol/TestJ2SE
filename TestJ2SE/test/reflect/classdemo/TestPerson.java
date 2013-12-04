package reflect.classdemo;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class TestPerson {
	
	@Test
	public void testClassName(){
		Person p = new Person();
		assertEquals("reflect.classdemo.Person", p.getClass().getName());
	}
	
	@Test
	public void testInstance() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		Class<?> cls =  Class.forName("reflect.classdemo.Person");		
		Person p = (Person) cls.newInstance();
		p.setAge(3);
		p.setName("张三");
		assertEquals(3, p.getAge());
		assertEquals("张三", p.getName());
	}
	
	@Test
	public void testArgsInstance() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		Class<?> cls =  Class.forName("reflect.classdemo.Person");		
		Constructor<?>[] con = cls.getConstructors();
		Person p = null;
		for (int i = 0; i < con.length; i++) {
			if (con[i].getGenericParameterTypes().length==0)
				p = (Person) con[i].newInstance();
		}				 
		p.setAge(3);
		p.setName("张三");
		assertEquals(3, p.getAge());
		assertEquals("张三", p.getName());
	}
	
	@Test
	public void testClassAllMessages() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		Class<?> cls =  Class.forName("reflect.classdemo.Person");		
		
		Package pack = cls.getPackage(); // 取得包
		assertEquals("package reflect.classdemo", pack.toString());
		assertEquals("reflect.classdemo", pack.getName());
		
		Method met[] = cls.getMethods();
		for (int x = 0; x < met.length; x++) {
			int mod = met[x].getModifiers();
			System.out.print(Modifier.toString(mod) + " "); // 还原修饰符
			String ret = met[x].getReturnType().getName();// 得到返回值类型
			System.out.print(ret + " ");
			System.out.print(met[x].getName() + "(");
			Class<?> param[] = met[x].getParameterTypes();// 取得全部的参数
			for (int y = 0; y < param.length; y++) {
				System.out.print(param[y].getName() + " arg-" + y);
				if (y < param.length - 1) {
					System.out.print(", ");
				}
			}
			System.out.print(") ");
			Class<?> exp[] = met[x].getExceptionTypes();
			if (exp.length > 0) {
				System.out.print("throws ");
				for (int y = 0; y < exp.length; y++) {
					System.out.print(exp[y].getName());
					if (y < exp.length - 1) {
						System.out.print(", ");
					}
				}
			}
			System.out.println();
		}
		
		{
			Field[] field = cls.getFields();
			for (int x = 0; x < field.length; x++) {
				int mod = field[x].getModifiers();
				System.out.print(Modifier.toString(mod) + " "); // 还原修饰符
				System.out.print(field[x].getType().getName() + " ");
				System.out.print(field[x].getName());
				System.out.println();
			}
		}
		{
			Field[] field = cls.getDeclaredFields();
			for (int x = 0; x < field.length; x++) {
				int mod = field[x].getModifiers();
				System.out.print(Modifier.toString(mod) + " "); // 还原修饰符
				System.out.print(field[x].getType().getName() + " ");
				System.out.print(field[x].getName());
				System.out.println();
			}
		}

	}

}
