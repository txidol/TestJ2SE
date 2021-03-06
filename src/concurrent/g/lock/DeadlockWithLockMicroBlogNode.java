package concurrent.g.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import concurrent.a.iexample.IBlogNode;
import concurrent.c.final_class.Author;
import concurrent.c.final_class.Update;

public class DeadlockWithLockMicroBlogNode implements IBlogNode {

  private static Update getUpdate(String s) {
    Update.Builder b = new Update.Builder();
    b.updateText(s).author(new Author("Ben"));
    return b.build();
  }

  private final String ident;

  private final Lock lock = new ReentrantLock();

  public DeadlockWithLockMicroBlogNode(String ident_) {
    ident = ident_;
  }

  public String getIdent() {
    return ident;
  }

  @Override
  public void propagateUpdate(Update upd_, IBlogNode backup_) {
    lock.lock();
    try {
      System.out.println(ident + ": recvd: " + upd_.getUpdateText()
          + " ; backup: " + backup_.getIdent());
      backup_.confirmUpdate(this, upd_);
    } finally {
      lock.unlock();
    }
  }

  @Override
  public boolean confirmUpdate(IBlogNode other_, Update upd_) {
    lock.lock();
    try {
      System.out.println(ident + ": recvd confirm: " + upd_.getUpdateText()
          + " from " + other_.getIdent());
    } finally {
      lock.unlock();
    }
    return false;
  }

  public static void main(String[] a) {
    final DeadlockWithLockMicroBlogNode local = new DeadlockWithLockMicroBlogNode(
        "localhost:8888");
    final DeadlockWithLockMicroBlogNode other = new DeadlockWithLockMicroBlogNode(
        "localhost:8988");
    final Update first = getUpdate("1");
    final Update second = getUpdate("2");

    new Thread(new Runnable() {
      public void run() {
        local.propagateUpdate(first, other);
      }
    }).start();

    new Thread(new Runnable() {
      public void run() {
        other.propagateUpdate(second, local);
      }
    }).start();
  }

}