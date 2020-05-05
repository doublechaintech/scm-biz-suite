
package com.doublechaintech.retailscm.potentialcustomer;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class PotentialCustomerManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public PotentialCustomerManagerException(String string) {
		super(string);
	}
	public PotentialCustomerManagerException(Message message) {
		super(message);
	}
	public PotentialCustomerManagerException(List<Message> messageList) {
		super(messageList);
	}

}


