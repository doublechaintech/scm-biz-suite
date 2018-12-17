
package com.doublechaintech.retailscm.offerapproval;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class OfferApprovalManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public OfferApprovalManagerException(String string) {
		super(string);
	}
	public OfferApprovalManagerException(Message message) {
		super(message);
	}
	public OfferApprovalManagerException(List<Message> messageList) {
		super(messageList);
	}

}


