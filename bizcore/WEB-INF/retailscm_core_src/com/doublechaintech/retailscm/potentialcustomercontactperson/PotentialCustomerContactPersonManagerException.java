
package com.doublechaintech.retailscm.potentialcustomercontactperson;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class PotentialCustomerContactPersonManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public PotentialCustomerContactPersonManagerException(String string) {
		super(string);
	}
	public PotentialCustomerContactPersonManagerException(Message message) {
		super(message);
	}
	public PotentialCustomerContactPersonManagerException(List<Message> messageList) {
		super(messageList);
	}

}


