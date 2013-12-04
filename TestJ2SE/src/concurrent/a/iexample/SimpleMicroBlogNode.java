package concurrent.a.iexample;

import concurrent.c.final_class.Update;

public interface SimpleMicroBlogNode {
  void propagateUpdate(Update upd_, SimpleMicroBlogNode backup_);

  void confirmUpdate(SimpleMicroBlogNode other_, Update update_);

  String getIdent();
}
