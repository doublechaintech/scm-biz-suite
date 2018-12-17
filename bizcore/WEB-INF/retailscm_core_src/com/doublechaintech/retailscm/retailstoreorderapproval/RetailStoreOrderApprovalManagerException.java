
package com.doublechaintech.retailscm.retailstoreorderapproval;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class RetailStoreOrderApprovalManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public RetailStoreOrderApprovalManagerException(String string) {
		super(string);
	}
	public RetailStoreOrderApprovalManagerException(Message message) {
		super(message);
	}
	public RetailStoreOrderApprovalManagerException(List<Message> messageList) {
		super(messageList);
	}

}


