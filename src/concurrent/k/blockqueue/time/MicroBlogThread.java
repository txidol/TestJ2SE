package concurrent.k.blockqueue.time;

import java.util.concurrent.BlockingQueue;

import concurrent.c.final_class.Update;

public abstract class MicroBlogThread extends Thread {
  protected final BlockingQueue<Update> updates;
  protected String text = "";
  protected final int pauseTime;
  private boolean shutdown = false;

  public MicroBlogThread(BlockingQueue<Update> lbq_, int pause_) {
    updates = lbq_;
    pauseTime = pause_;
  }

  public synchronized void shutdown() {
    shutdown = true;
  }

  @Override
  public void run() {
    while (!shutdown) {
      doAction();
      try {
        Thread.sleep(pauseTime);
      } catch (InterruptedException e) {
        shutdown = true;
      }
    }
  }

  public abstract void doAction();
}
