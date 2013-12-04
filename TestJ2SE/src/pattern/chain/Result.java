package pattern.chain;

public interface Result {
  
    public void execute(ActionInvocation invocation) throws Exception;

}
