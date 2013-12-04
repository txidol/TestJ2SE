package pattern.chain;
/**
 * Provides default implementations of optional lifecycle methods
 */
public abstract class AbstractInterceptor implements Interceptor {
	
    //在初始化时，执行的钩子，实现类可以不实现，这里我们不做模拟
	public void init() {}    
    public void destroy() {}

    /**
     * 拦截器一定需要覆写的方法
     */
    public abstract String intercept(ActionInvocation invocation) throws Exception;
}
