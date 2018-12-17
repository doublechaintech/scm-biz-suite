
package com.doublechaintech.retailscm.retailstoreorderpicking;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class RetailStoreOrderPickingManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public RetailStoreOrderPickingManagerException(String string) {
		super(string);
	}
	public RetailStoreOrderPickingManagerException(Message message) {
		super(message);
	}
	public RetailStoreOrderPickingManagerException(List<Message> messageList) {
		super(messageList);
	}

}


