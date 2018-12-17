
package com.doublechaintech.retailscm.retailstoreorder;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class RetailStoreOrderManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public RetailStoreOrderManagerException(String string) {
		super(string);
	}
	public RetailStoreOrderManagerException(Message message) {
		super(message);
	}
	public RetailStoreOrderManagerException(List<Message> messageList) {
		super(messageList);
	}

}


