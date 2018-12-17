
package com.doublechaintech.retailscm.supplyorderprocessing;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class SupplyOrderProcessingManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public SupplyOrderProcessingManagerException(String string) {
		super(string);
	}
	public SupplyOrderProcessingManagerException(Message message) {
		super(message);
	}
	public SupplyOrderProcessingManagerException(List<Message> messageList) {
		super(messageList);
	}

}


