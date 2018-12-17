
package com.doublechaintech.retailscm.retailstoreorderdelivery;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class RetailStoreOrderDeliveryManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public RetailStoreOrderDeliveryManagerException(String string) {
		super(string);
	}
	public RetailStoreOrderDeliveryManagerException(Message message) {
		super(message);
	}
	public RetailStoreOrderDeliveryManagerException(List<Message> messageList) {
		super(messageList);
	}

}


