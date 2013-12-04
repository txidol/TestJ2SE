package concurrent.h.countdownlatch;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/**
 * <p>Copyright:Copyright(c)2013</p>
 * <p>Company:Mopon</p>
 * <p>Description: </p>
 * @date 2013Äê12ÔÂ3ÈÕ
 * @author Ì·Ïè
 * @version 1.0
 */
public class ProcessingThread extends Thread {
	private final String ident;
	private final CountDownLatch latch;
	private static int MAX_THREADS = 7;
	
	public ProcessingThread(String ident_, CountDownLatch cdl_) {
		ident = ident_;
		latch = cdl_;
	}

	public String getIdentifier() {
		return ident;
	}

	public void initialize() {
		latch.countDown();
	}

	public void run() {
		initialize();
	}
	
	public static void main(String[] a) {
		final int quorum = 1 + (int) (MAX_THREADS / 2);
		final CountDownLatch cdl = new CountDownLatch(quorum);
		final Set<ProcessingThread> nodes = new HashSet<>();
	    
	    try {
	    	for (int i = 0; i < MAX_THREADS; i++) {
	    		 ProcessingThread local = new ProcessingThread(
	    		            "localhost:" + (9000 + i), cdl);
	    		 nodes.add(local);
	    		 local.start();
	    		 System.out.println("localhost:" + (9000 + i) + "|"+cdl.getCount());
			}
			cdl.await();
			System.out.println(cdl.getCount());
		} catch (InterruptedException e) {
			
		}finally{
			
		}
//	    final int quorum = 1 + (int) (MAX_THREADS / 2);
//	    final CountDownLatch cdl = new CountDownLatch(quorum);
//
//	    final Set<ProcessingThread> nodes = new HashSet<>();
//	    try {
//	      for (int i = 0; i < MAX_THREADS; i++) {
//	        ProcessingThread local = new ProcessingThread(
//	            "localhost:" + (9000 + i), cdl);
//	        nodes.add(local);
//	        local.start();
//	      }
//	      cdl.await();
//	    } catch (InterruptedException e) {
//
//	    } finally {
//	    }
	}
}
