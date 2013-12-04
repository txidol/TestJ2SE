package concurrent.f.atomic;

import java.util.concurrent.atomic.AtomicLong;

/**
 * <p>Copyright:Copyright(c)2013</p>
 * <p>Company:Mopon</p>
 * <p>Description: </p>
 * @date 2013年12月3日
 * @author 谭翔
 * @version 1.0
 */
public class AtomicClass {
	
	private final AtomicLong sequenceNumber = new AtomicLong(0);
	//序列号机制，利用原子操作方法
	
	public long nextID(){
		return sequenceNumber.getAndIncrement();
	}
	
	public long decreID(){
		return sequenceNumber.getAndDecrement();
	}
	
	public long set(long newValue){
		return sequenceNumber.getAndSet(newValue);
	}
	
	public long add(long delta){
		return sequenceNumber.getAndAdd(delta);
	}
}
