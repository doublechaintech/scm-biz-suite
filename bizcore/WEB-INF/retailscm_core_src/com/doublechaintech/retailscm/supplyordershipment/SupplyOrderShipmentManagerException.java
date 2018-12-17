
package com.doublechaintech.retailscm.supplyordershipment;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class SupplyOrderShipmentManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public SupplyOrderShipmentManagerException(String string) {
		super(string);
	}
	public SupplyOrderShipmentManagerException(Message message) {
		super(message);
	}
	public SupplyOrderShipmentManagerException(List<Message> messageList) {
		super(messageList);
	}

}


