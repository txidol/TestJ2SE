package concurrent.k.blockqueue;

import java.util.concurrent.BlockingQueue;

public class Veterinarian extends Thread {
  protected final BlockingQueue<Appointment<Pet>> appts;
  //put() �������������÷����̵߳ȴ������ڳ��ռ�
  //take() �������Ϊ�գ��ᵼ��ȡ���߳�����
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
      //���Ϊ�գ���������
      Pet patient = ap.getPatient();
      patient.examine();
    } catch (InterruptedException e) {
      shutdown = true;
    }
  }
}