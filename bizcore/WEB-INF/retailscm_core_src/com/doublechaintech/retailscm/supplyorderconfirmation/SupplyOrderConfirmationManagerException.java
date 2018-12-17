
package com.doublechaintech.retailscm.supplyorderconfirmation;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class SupplyOrderConfirmationManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public SupplyOrderConfirmationManagerException(String string) {
		super(string);
	}
	public SupplyOrderConfirmationManagerException(Message message) {
		super(message);
	}
	public SupplyOrderConfirmationManagerException(List<Message> messageList) {
		super(messageList);
	}

}


