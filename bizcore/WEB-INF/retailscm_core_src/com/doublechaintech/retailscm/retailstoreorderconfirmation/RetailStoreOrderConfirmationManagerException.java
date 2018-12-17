
package com.doublechaintech.retailscm.retailstoreorderconfirmation;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class RetailStoreOrderConfirmationManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public RetailStoreOrderConfirmationManagerException(String string) {
		super(string);
	}
	public RetailStoreOrderConfirmationManagerException(Message message) {
		super(message);
	}
	public RetailStoreOrderConfirmationManagerException(List<Message> messageList) {
		super(messageList);
	}

}


