
package com.doublechaintech.retailscm.retailstoreorderpaymentgroup;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class RetailStoreOrderPaymentGroupManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public RetailStoreOrderPaymentGroupManagerException(String string) {
		super(string);
	}
	public RetailStoreOrderPaymentGroupManagerException(Message message) {
		super(message);
	}
	public RetailStoreOrderPaymentGroupManagerException(List<Message> messageList) {
		super(messageList);
	}

}


