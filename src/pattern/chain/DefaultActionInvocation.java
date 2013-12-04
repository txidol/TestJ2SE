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

	//这里我们外部传入内容，Struts采用inject注入以及调用init方法初始化内容
	public DefaultActionInvocation(List<InterceptorMapping> interceptorsTree,
			Action action) {
		this.interceptors = interceptorsTree.iterator();
		this.action = action;
	}

	public String invoke() throws Exception {

		if (executed) {
			throw new IllegalStateException("Action has already executed");
		}

		//遍历拦截器
		if (interceptors.hasNext()) {
			final InterceptorMapping interceptor = interceptors.next();
			resultCode = interceptor.getInterceptor().intercept(
					DefaultActionInvocation.this);
		} 
		//执行Action
		else{
			resultCode = invokeActionOnly();
		}
		
		//这里打个假设，在Struts实际会根据resultCode，判断创建哪类Result以及执行chian转发等
		//这里只是一个demo，我们模拟执行的流程		
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
				String methodName = "execute";//这里我们直接设定反射执行execute方法
				method = getAction().getClass().getMethod(methodName,
					EMPTY_CLASS_ARRAY);
			} catch (NoSuchMethodException e) {
				System.out.println("没有此方法");
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
		//返回值直接返回，这里稍微改写了
		return (String) methodResult;
	}

	private void executeResult() throws Exception {
		result = createResult();
		//假设就只执行成功的结果   注意 这里改写了！！！！
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
