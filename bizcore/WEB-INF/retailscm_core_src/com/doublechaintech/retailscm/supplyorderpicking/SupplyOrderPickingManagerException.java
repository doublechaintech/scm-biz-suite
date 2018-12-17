
package com.doublechaintech.retailscm.supplyorderpicking;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class SupplyOrderPickingManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public SupplyOrderPickingManagerException(String string) {
		super(string);
	}
	public SupplyOrderPickingManagerException(Message message) {
		super(message);
	}
	public SupplyOrderPickingManagerException(List<Message> messageList) {
		super(messageList);
	}

}


