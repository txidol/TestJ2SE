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
    //�����̳߳� ��Ҫ���ô�С ��Ȼ�������

    MicroBlogThread t1 = new MicroBlogThread(lbq, 10) {
      public void doAction() {
        text = text + "X";
        Update u = ub.author(new Author("Tallulah")).updateText(text).build();
        boolean handed = false;
        try {
          handed = updates.offer(u, 100, TimeUnit.MILLISECONDS);
          //��ʱ���룬�����˳���
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
