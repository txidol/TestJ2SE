package pattern.chain;

public class SelfTwoInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
    	String result = null ;   	
    	System.out.println("intercept SelfTwoInterceptor before aop");
		result = invocation.invoke(); 
		System.out.println("intercept SelfTwoInterceptor after aop");				
		return result; 
    }  
}
