
package com.doublechaintech.retailscm.retailstorecreation;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class RetailStoreCreationManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public RetailStoreCreationManagerException(String string) {
		super(string);
	}
	public RetailStoreCreationManagerException(Message message) {
		super(message);
	}
	public RetailStoreCreationManagerException(List<Message> messageList) {
		super(messageList);
	}

}


