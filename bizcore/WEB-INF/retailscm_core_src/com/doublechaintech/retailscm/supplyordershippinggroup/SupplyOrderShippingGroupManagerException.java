
package com.doublechaintech.retailscm.supplyordershippinggroup;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class SupplyOrderShippingGroupManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public SupplyOrderShippingGroupManagerException(String string) {
		super(string);
	}
	public SupplyOrderShippingGroupManagerException(Message message) {
		super(message);
	}
	public SupplyOrderShippingGroupManagerException(List<Message> messageList) {
		super(messageList);
	}

}


