package concurrent.n.scheduled_thread_pool_executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * <p>Copyright:Copyright(c)2013</p>
 * <p>Company:Mopon</p>
 * <p>Description: </p>
 * @date 2013Äê12ÔÂ4ÈÕ
 * @author Ì·Ïè
 * @version 1.0
 */
public class ScheduledThreadPoolExecutorClass {
	private ScheduledExecutorService stpe;
	private ScheduledFuture<?> hndl;
	
	BlockingQueue<WorkUnit<String>> lbq =
			new LinkedBlockingQueue<>();
			
	private void run(){
		stpe = Executors.newScheduledThreadPool(2);
		
		final Runnable msgReader = new Runnable() {
			
			@Override
			public void run() {
				String nextMsg = lbq.poll().getWork();
				if(nextMsg != null){
					System.out.println("Msg recvd: "+ nextMsg);
				}
			}
		};
		
		hndl =stpe.scheduleAtFixedRate(msgReader, 10, 10, TimeUnit.MILLISECONDS);
	}
	
	private void cancel(){
		final ScheduledFuture<?> myHndl = hndl;
		
		stpe.schedule(new Runnable() {			
			@Override
			public void run() {
				myHndl.cancel(true);
			}
		}, 10, TimeUnit.MILLISECONDS);
	}
	
	public static void main(String[] args) {	
		ScheduledThreadPoolExecutorClass s = new ScheduledThreadPoolExecutorClass();
		for (int i = 0; i < 10; i++) {
			s.lbq.add(new WorkUnit<String>(i+""));
		}		
		s.run();
		for (int i = 10; i < 20; i++) {
			s.lbq.add(new WorkUnit<String>(i+""));
		}	
		
	}
}
