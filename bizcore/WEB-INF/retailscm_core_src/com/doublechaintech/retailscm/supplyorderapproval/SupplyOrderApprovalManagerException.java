
package com.doublechaintech.retailscm.supplyorderapproval;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class SupplyOrderApprovalManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public SupplyOrderApprovalManagerException(String string) {
		super(string);
	}
	public SupplyOrderApprovalManagerException(Message message) {
		super(message);
	}
	public SupplyOrderApprovalManagerException(List<Message> messageList) {
		super(messageList);
	}

}


