package concurrent.a.iexample;

import concurrent.c.final_class.Update;


/**
 * <p>Copyright:Copyright(c)2013</p>
 * <p>Company:Mopon</p>
 * <p>Description: </p>
 * @date 2013Äê12ÔÂ3ÈÕ
 * @author Ì·Ïè
 * @version 1.0
 */
public interface IBlogNode {
	void propagateUpdate(Update upd_, IBlogNode backup_);

	boolean confirmUpdate(IBlogNode other_, Update update_);

	String getIdent();
}
