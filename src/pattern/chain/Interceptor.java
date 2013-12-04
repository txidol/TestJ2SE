package pattern.chain;

public interface Interceptor{
 
    void destroy();

    void init();

    String intercept(ActionInvocation invocation) throws Exception;

}
