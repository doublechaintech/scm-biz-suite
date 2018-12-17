
package com.doublechaintech.retailscm.retailstoreclosing;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class RetailStoreClosingManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public RetailStoreClosingManagerException(String string) {
		super(string);
	}
	public RetailStoreClosingManagerException(Message message) {
		super(message);
	}
	public RetailStoreClosingManagerException(List<Message> messageList) {
		super(messageList);
	}

}


