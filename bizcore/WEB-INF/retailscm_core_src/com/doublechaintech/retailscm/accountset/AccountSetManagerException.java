
package com.doublechaintech.retailscm.accountset;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class AccountSetManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public AccountSetManagerException(String string) {
		super(string);
	}
	public AccountSetManagerException(Message message) {
		super(message);
	}
	public AccountSetManagerException(List<Message> messageList) {
		super(messageList);
	}

}


