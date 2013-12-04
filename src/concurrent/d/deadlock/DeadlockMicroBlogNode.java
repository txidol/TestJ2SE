package concurrent.d.deadlock;

import concurrent.a.iexample.IBlogNode;
import concurrent.c.final_class.Author;
import concurrent.c.final_class.Update;

public class DeadlockMicroBlogNode implements IBlogNode {

  private static Update getUpdate(String s) {
    Update.Builder b = new Update.Builder();
    b.updateText(s).author(new Author("Ben"));

    return b.build();
  }

  private final String ident;

  public DeadlockMicroBlogNode(String ident_) {
    ident = ident_;
  }

  public String getIdent() {
    return ident;
  }

  @Override
  public synchronized void propagateUpdate(Update upd_,
		  IBlogNode backup_) {
    System.out.println(ident + ": recvd: " + upd_.getUpdateText()
        + " ; backup: " + backup_.getIdent());
    backup_.confirmUpdate(this, upd_);
  }

  @Override
  public synchronized boolean confirmUpdate(IBlogNode other_,
      Update update_) {
    System.out.println(ident + ": recvd confirm: " + update_.getUpdateText()
        + " from " + other_.getIdent());
    return false;
  }

  public static void main(String[] a) {
    final DeadlockMicroBlogNode local = new DeadlockMicroBlogNode(
        "localhost:8888");
    final DeadlockMicroBlogNode other = new DeadlockMicroBlogNode(
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