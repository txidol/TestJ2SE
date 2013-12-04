package pattern.chain;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

public class DefaultActionInvocation implements ActionInvocation {
	protected Iterator<InterceptorMapping> interceptors;
	protected Action action = new SelfAction();

	@SuppressWarnings("rawtypes")
	private static final Class[] EMPTY_CLASS_ARRAY = new Class[0];
	private static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];

	protected Result result;
	protected String resultCode;

	protected boolean executed = false;

	//���������ⲿ�������ݣ�Struts����injectע���Լ�����init������ʼ������
	public DefaultActionInvocation(List<InterceptorMapping> interceptorsTree,
			Action action) {
		this.interceptors = interceptorsTree.iterator();
		this.action = action;
	}

	public String invoke() throws Exception {

		if (executed) {
			throw new IllegalStateException("Action has already executed");
		}

		//����������
		if (interceptors.hasNext()) {
			final InterceptorMapping interceptor = interceptors.next();
			resultCode = interceptor.getInterceptor().intercept(
					DefaultActionInvocation.this);
		} 
		//ִ��Action
		else{
			resultCode = invokeActionOnly();
		}
		
		//���������裬��Strutsʵ�ʻ����resultCode���жϴ�������Result�Լ�ִ��chianת����
		//����ֻ��һ��demo������ģ��ִ�е�����		
		if(Action.SUCCESS.equals(resultCode)){  
			executeResult();
		}
		

		executed = true;
		return resultCode;

	}

	public String invokeActionOnly() throws Exception {
		return invokeAction(getAction());
	}

	protected String invokeAction(Object action) throws Exception {
		
		boolean methodCalled = false;
		Object methodResult = null;
		Method method = null;
		try {		
			try{
				String methodName = "execute";//��������ֱ���趨����ִ��execute����
				method = getAction().getClass().getMethod(methodName,
					EMPTY_CLASS_ARRAY);
			} catch (NoSuchMethodException e) {
				System.out.println("û�д˷���");
				methodCalled = true;
			}
			if (!methodCalled) {
				methodResult = method.invoke(action, EMPTY_OBJECT_ARRAY);
			}			
		}catch (InvocationTargetException e) {
			// We try to return the source exception.
			Throwable t = e.getTargetException();
			if (t instanceof Exception) {
				throw (Exception) t;
			} else {
				throw e;
			}
		}
		//����ֱֵ�ӷ��أ�������΢��д��
		return (String) methodResult;
	}

	private void executeResult() throws Exception {
		result = createResult();
		//�����ִֻ�гɹ��Ľ��   ע�� �����д�ˣ�������
		if (result != null && Action.SUCCESS.equals(resultCode)) {
			result.execute(this);
		}
	}

	public Result createResult() throws Exception {
		return new SelfResult();
	}

	public Object getAction() {
		return action;
	}

	public boolean isExecuted() {
		return executed;
	}

	public Result getResult() throws Exception {
		return result;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		if (isExecuted())
			throw new IllegalStateException("Result has already been executed.");
		this.resultCode = resultCode;
	}
}
