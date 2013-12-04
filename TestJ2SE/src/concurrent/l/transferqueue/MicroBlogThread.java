package concurrent.l.transferqueue;

import java.util.concurrent.TransferQueue;

import concurrent.c.final_class.Update;

public abstract class MicroBlogThread extends Thread {
  protected final TransferQueue<Update> updates;
  protected String text = "";
  protected final int pauseTime;
  private boolean shutdown = false;

  public MicroBlogThread(TransferQueue<Update> lbq_, int pause_) {
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
