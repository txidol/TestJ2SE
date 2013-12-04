package concurrent.b.sync_class;

import java.util.HashMap;
import java.util.Map;

import concurrent.a.iexample.IBlogNode;
import concurrent.c.final_class.Update;

/**
 * <p>Copyright:Copyright(c)2013</p>
 * <p>Company:Mopon</p>
 * <p>Description: </p>
 * @date 2013Äê12ÔÂ3ÈÕ
 * @author Ì·Ïè
 * @version 1.0
 */
public class ExampleTimingBode implements IBlogNode {

	private final String identifier;
	private final Map<Update ,Long> arrivalTime = new HashMap<>();
	
	public ExampleTimingBode(String identifier_){
		identifier=identifier_;
	}
	
	@Override
	public synchronized String getIdent() {	
		return identifier;
	}
		
	@Override
	public synchronized void propagateUpdate(Update upd_, IBlogNode backup_) {
		long current = System.currentTimeMillis();
		arrivalTime.put(upd_, current);
	}

	@Override
	public synchronized boolean confirmUpdate(IBlogNode other_, Update update_) {
		Long recvd = arrivalTime.get(update_);
		System.out.println("Recvd confirm: " + update_.getUpdateText() + " from "
		        + other_.getIdent());
		return recvd!=null;

	}



}
