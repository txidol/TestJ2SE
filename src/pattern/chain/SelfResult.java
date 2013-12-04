package pattern.chain;

public class SelfResult implements Result {
	@Override
	public void execute(ActionInvocation invocation) throws Exception {

		System.out.println("------------------------------------Result is "
				+ invocation.getResultCode() + " do nothing or other");
	}
}
