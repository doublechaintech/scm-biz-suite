
package com.doublechaintech.retailscm.retailstoreordershipment;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class RetailStoreOrderShipmentManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public RetailStoreOrderShipmentManagerException(String string) {
		super(string);
	}
	public RetailStoreOrderShipmentManagerException(Message message) {
		super(message);
	}
	public RetailStoreOrderShipmentManagerException(List<Message> messageList) {
		super(messageList);
	}

}


