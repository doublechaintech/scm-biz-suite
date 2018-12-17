
package com.doublechaintech.retailscm.supplyorderdelivery;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class SupplyOrderDeliveryManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public SupplyOrderDeliveryManagerException(String string) {
		super(string);
	}
	public SupplyOrderDeliveryManagerException(Message message) {
		super(message);
	}
	public SupplyOrderDeliveryManagerException(List<Message> messageList) {
		super(messageList);
	}

}


