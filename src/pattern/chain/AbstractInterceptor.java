package pattern.chain;
/**
 * Provides default implementations of optional lifecycle methods
 */
public abstract class AbstractInterceptor implements Interceptor {
	
    //�ڳ�ʼ��ʱ��ִ�еĹ��ӣ�ʵ������Բ�ʵ�֣��������ǲ���ģ��
	public void init() {}    
    public void destroy() {}

    /**
     * ������һ����Ҫ��д�ķ���
     */
    public abstract String intercept(ActionInvocation invocation) throws Exception;
}
