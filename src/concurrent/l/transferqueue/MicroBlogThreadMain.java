package concurrent.l.transferqueue;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

import concurrent.c.final_class.Author;
import concurrent.c.final_class.Update;

public class MicroBlogThreadMain {

  public static void main(String[] a) {
    final Update.Builder ub = new Update.Builder();
    final TransferQueue<Update> lbq = new LinkedTransferQueue<>();
    //如果接收线程处于等待状态，transfer（）马上把工作项传给它，否则就会阻塞直到取走工作项  [高效]

    MicroBlogThread t1 = new MicroBlogThread(lbq, 10) {
      public void doAction() {
        text = text + "X";
        Update u = ub.author(new Author("Tallulah")).updateText(text).build();
        boolean handed = false;
        try {
          handed = updates.offer(u, 100, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
        }
        if (!handed)
          System.out
              .println("Unable to handoff Update to Queue due to timeout");
      }
    };

    MicroBlogThread t2 = new MicroBlogThread(lbq, 1000) {
      public void doAction() {
        @SuppressWarnings("unused")
		Update u = null;
        try {
          u = updates.take();
        } catch (InterruptedException e) {
          return;
        }
      }
    };
    t1.start();
    t2.start();
  }

}
