package concurrent.k.blockqueue.time;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import concurrent.c.final_class.Author;
import concurrent.c.final_class.Update;

public class MicroBlogThreadMain {

  public static void main(String[] a) {
    final Update.Builder ub = new Update.Builder();
    final BlockingQueue<Update> lbq = new LinkedBlockingQueue<>(100);
    //相连线程池 需要设置大小 不然容易溢出

    MicroBlogThread t1 = new MicroBlogThread(lbq, 10) {
      public void doAction() {
        text = text + "X";
        Update u = ub.author(new Author("Tallulah")).updateText(text).build();
        boolean handed = false;
        try {
          handed = updates.offer(u, 100, TimeUnit.MILLISECONDS);
          //超时放入，可以退出来
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
