package concurrent.e.volatitle;
/**
 * <p>Copyright:Copyright(c)2013</p>
 * <p>Company:Mopon</p>
 * <p>Description: </p>
 * @date 2013年12月3日
 * @author 谭翔
 * @version 1.0
 */
public class VolatileClass {
	
	private volatile int count = 0;
	//使用前从内存读出来，所写值指令完成前刷回内存，真正线程安全，写入时需不依赖当前状态
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}
