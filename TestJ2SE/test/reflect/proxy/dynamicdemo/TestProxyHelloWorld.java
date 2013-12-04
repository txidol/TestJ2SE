package reflect.proxy.dynamicdemo;

//import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.junit.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class TestProxyHelloWorld {

	@Test
	public void test() {
		//IHelloWorld hw = new HelloWorld();
		//InvocationHandler  handler = new HelloWorldHandler(hw);
		
		IHelloWorld hw = mock(IHelloWorld.class);
		
		HelloWorldHandler handler1 = new HelloWorldHandler(hw);
		HelloWorldHandler handler = spy(handler1);
		
		IHelloWorld proxy = (IHelloWorld) Proxy.newProxyInstance(hw.getClass()
				.getClassLoader(), hw.getClass().getInterfaces(), handler);
		
		proxy.sayHelloWorld();
		
		InOrder inOrder = inOrder(handler,hw);
		
		inOrder.verify(handler,times(1)).doBefore();		
		inOrder.verify(hw,times(1)).sayHelloWorld();
		inOrder.verify(handler,times(1)).doAfter();
		
	}

}
