package pattern.chain;

public interface ActionInvocation{

    Object getAction();

    boolean isExecuted();

    Result getResult() throws Exception;

    String getResultCode();

    void setResultCode(String resultCode);

    String invoke() throws Exception;
 
    String invokeActionOnly() throws Exception;

}
