package concurrent.f.atomic;

import java.util.concurrent.atomic.AtomicLong;

/**
 * <p>Copyright:Copyright(c)2013</p>
 * <p>Company:Mopon</p>
 * <p>Description: </p>
 * @date 2013��12��3��
 * @author ̷��
 * @version 1.0
 */
public class AtomicClass {
	
	private final AtomicLong sequenceNumber = new AtomicLong(0);
	//���кŻ��ƣ�����ԭ�Ӳ�������
	
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
