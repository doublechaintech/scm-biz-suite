
package com.doublechaintech.retailscm.retailstoreorderlineitem;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class RetailStoreOrderLineItemManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public RetailStoreOrderLineItemManagerException(String string) {
		super(string);
	}
	public RetailStoreOrderLineItemManagerException(Message message) {
		super(message);
	}
	public RetailStoreOrderLineItemManagerException(List<Message> messageList) {
		super(messageList);
	}

}


