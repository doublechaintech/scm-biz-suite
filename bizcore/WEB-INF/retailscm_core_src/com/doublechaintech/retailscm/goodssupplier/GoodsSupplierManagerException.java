
package com.doublechaintech.retailscm.goodssupplier;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class GoodsSupplierManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public GoodsSupplierManagerException(String string) {
		super(string);
	}
	public GoodsSupplierManagerException(Message message) {
		super(message);
	}
	public GoodsSupplierManagerException(List<Message> messageList) {
		super(messageList);
	}

}


