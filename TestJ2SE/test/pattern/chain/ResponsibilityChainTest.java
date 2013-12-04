package pattern.chain;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * ������������
 * @author tanx
 *
 */
public class ResponsibilityChainTest {

	private List<InterceptorMapping> interceptorsTree;
	private Action action;
	private ActionInvocation actionInvocation;
	
	//��ʼ����������Action��ActionInvocation���൱����������
	@Before	
	public void setUp(){
		
		interceptorsTree = new ArrayList<InterceptorMapping>();
		Interceptor one = new SelfOneInterceptor();
		Interceptor two = new SelfTwoInterceptor();
		InterceptorMapping oneIntercepror = new InterceptorMapping("one", one);
		InterceptorMapping twoIntercepror = new InterceptorMapping("two", two);
		interceptorsTree.add(oneIntercepror);
		interceptorsTree.add(twoIntercepror);
		
		action = new SelfAction();
		
		actionInvocation = new DefaultActionInvocation(interceptorsTree, action);
	}
	
	@Test
	public void test() throws Exception{
		actionInvocation.invoke();		
		assertEquals(Action.SUCCESS,actionInvocation.getResultCode());
	}
}
