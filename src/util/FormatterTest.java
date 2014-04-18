package util;


import java.util.Calendar;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;

import static java.util.Calendar.*;
import static org.junit.Assert.*;

public class FormatterTest {
	
	private Formatter formatter;

	@Before
	public void setUp(){
		StringBuilder sb = new StringBuilder();
		formatter = new Formatter(sb,Locale.US);		 
	}
	
	//字符串填充、注意顺序
	@Test
	public void demoTest(){	
		 formatter = formatter.format("%4$2s %3$2s %2$2s %1$2s",
				 "a", "b", "c", "d");
		 assertEquals(" d  c  b  a", formatter.toString()); 	
	}
	
	//数字填充，注意空格，加号，逗号
	@Test
	public void demoTest1(){
		 formatter = formatter.format(Locale.FRANCE, "e = %+10.4f", Math.E);
		 assertEquals("e =    +2,7183", formatter.toString()); 
	}
	
	//浮点型数字填充，注意负号处理，逗号，小数点，括号
	@Test
	public void demoTest2(){	
		 formatter =   formatter.format("Amount gained or lost since last statement: $ %(,.2f",
				 -6217.58F);
		 assertEquals("Amount gained or lost since last statement: $ (6,217.58)", 
				 formatter.toString()); 
	}
	
	//系统格式化输出
	@Test
	public void demoTest3System(){
		   // Writes a formatted string to System.out.
		   System.out.format("Local time: %tT", Calendar.getInstance());
		   // -> "Local time: 13:34:18"
		   
		   // Writes formatted output to System.err.
		   System.err.printf("Unable to open file '%1$s': %2$s",
		                     "food", "No such file or directory");
		   // -> "Unable to open file 'food': No such file or directory"

	}
	
	//处理日期
	@Test
	public void demoTest4String(){
		  Calendar c = new GregorianCalendar(1995, MAY, 23);
		  String s = String.format("Duke's Birthday: %1$tm %1$te, %1$tY", c);
		  assertEquals("Duke's Birthday: 05 23, 1995", s); 
	}
	
	
}
