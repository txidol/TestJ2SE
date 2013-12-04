package reflect.proxy.dynamicdemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HelloWorldHandler  implements InvocationHandler {
	// Ҫ�����ԭʼ����
	private Object objOriginal;
	/** 
	 * ���캯���� Ҫ�����ԭʼ����
	 */
	public HelloWorldHandler(Object obj) {
		this.objOriginal = obj;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result;
		
		// ��������֮ǰ
		doBefore();
		// ����ԭʼ����ķ���
		result = method.invoke(this.objOriginal, args);
		// ��������֮��
		doAfter();
		
		return result;
	}
	
	public void doBefore() {
		System.out.println("--before method invoke!");
	}
	public void doAfter() {
		System.out.println("--after method invoke!");
	}


}
