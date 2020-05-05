
package com.doublechaintech.retailscm.goodsshelfstockcount;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class GoodsShelfStockCountManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public GoodsShelfStockCountManagerException(String string) {
		super(string);
	}
	public GoodsShelfStockCountManagerException(Message message) {
		super(message);
	}
	public GoodsShelfStockCountManagerException(List<Message> messageList) {
		super(messageList);
	}

}


