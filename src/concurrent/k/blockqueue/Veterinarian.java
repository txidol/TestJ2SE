package concurrent.k.blockqueue;

import java.util.concurrent.BlockingQueue;

public class Veterinarian extends Thread {
  protected final BlockingQueue<Appointment<Pet>> appts;
  //put() 队列已满，会让放入线程等待队列腾出空间
  //take() 如果队列为空，会导致取出线程阻塞
  protected String text = "";
  protected final int restTime;
  private boolean shutdown = false;

  public Veterinarian(BlockingQueue<Appointment<Pet>> lbq, int pause) {
    appts = lbq;
    restTime = pause;
  }

  public synchronized void shutdown() {
    shutdown = true;
  }

  @Override
  public void run() {
    while (!shutdown) {
      seePatient();
      try {
        Thread.sleep(restTime);
      } catch (InterruptedException e) {
        shutdown = true;
      }
    }
  }

  public void seePatient() {
    try {
      Appointment<Pet> ap = appts.take();
      //如果为空，将会阻塞
      Pet patient = ap.getPatient();
      patient.examine();
    } catch (InterruptedException e) {
      shutdown = true;
    }
  }
}