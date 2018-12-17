
package com.doublechaintech.retailscm.consumerorderapproval;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class ConsumerOrderApprovalManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public ConsumerOrderApprovalManagerException(String string) {
		super(string);
	}
	public ConsumerOrderApprovalManagerException(Message message) {
		super(message);
	}
	public ConsumerOrderApprovalManagerException(List<Message> messageList) {
		super(messageList);
	}

}


