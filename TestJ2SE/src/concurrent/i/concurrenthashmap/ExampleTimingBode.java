package concurrent.i.concurrenthashmap;

import java.util.concurrent.ConcurrentHashMap;

import concurrent.a.iexample.IBlogNode;
import concurrent.c.final_class.Update;

/**
 * <p>Copyright:Copyright(c)2013</p>
 * <p>Company:Mopon</p>
 * <p>Description: </p>
 * @date 2013��12��3��
 * @author ̷��
 * @version 1.0
 */
public class ExampleTimingBode implements IBlogNode {

	private final String identifier;
	private final ConcurrentHashMap<Update ,Long> arrivalTime = new ConcurrentHashMap<>();
	//����ʾͬ������ȫ��Ч   putIfAbsent remove replace
	
	public ExampleTimingBode(String identifier_){
		identifier=identifier_;
	}
	
	@Override
	public String getIdent() {	
		return identifier;
	}
		
	@Override
	public void propagateUpdate(Update upd_, IBlogNode backup_) {
		long current = System.currentTimeMillis();
		arrivalTime.putIfAbsent(upd_, current);
	}

	@Override
	public boolean confirmUpdate(IBlogNode other_, Update update_) {
		Long recvd = arrivalTime.get(update_);		
		return recvd!=null;

	}



}
