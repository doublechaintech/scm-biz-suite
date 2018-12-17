
package com.doublechaintech.retailscm.goodspackaging;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class GoodsPackagingManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public GoodsPackagingManagerException(String string) {
		super(string);
	}
	public GoodsPackagingManagerException(Message message) {
		super(message);
	}
	public GoodsPackagingManagerException(List<Message> messageList) {
		super(messageList);
	}

}


