
package com.doublechaintech.retailscm.goodsshelf;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class GoodsShelfManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public GoodsShelfManagerException(String string) {
		super(string);
	}
	public GoodsShelfManagerException(Message message) {
		super(message);
	}
	public GoodsShelfManagerException(List<Message> messageList) {
		super(messageList);
	}

}


