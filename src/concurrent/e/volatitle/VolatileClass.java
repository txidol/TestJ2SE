package concurrent.e.volatitle;
/**
 * <p>Copyright:Copyright(c)2013</p>
 * <p>Company:Mopon</p>
 * <p>Description: </p>
 * @date 2013��12��3��
 * @author ̷��
 * @version 1.0
 */
public class VolatileClass {
	
	private volatile int count = 0;
	//ʹ��ǰ���ڴ����������дֵָ�����ǰˢ���ڴ棬�����̰߳�ȫ��д��ʱ�費������ǰ״̬
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}
