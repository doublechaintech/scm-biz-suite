
package com.doublechaintech.retailscm.potentialcustomercontact;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class PotentialCustomerContactManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public PotentialCustomerContactManagerException(String string) {
		super(string);
	}
	public PotentialCustomerContactManagerException(Message message) {
		super(message);
	}
	public PotentialCustomerContactManagerException(List<Message> messageList) {
		super(messageList);
	}

}


