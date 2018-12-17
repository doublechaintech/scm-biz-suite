
package com.doublechaintech.retailscm.retailstoreorderprocessing;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class RetailStoreOrderProcessingManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public RetailStoreOrderProcessingManagerException(String string) {
		super(string);
	}
	public RetailStoreOrderProcessingManagerException(Message message) {
		super(message);
	}
	public RetailStoreOrderProcessingManagerException(List<Message> messageList) {
		super(messageList);
	}

}


