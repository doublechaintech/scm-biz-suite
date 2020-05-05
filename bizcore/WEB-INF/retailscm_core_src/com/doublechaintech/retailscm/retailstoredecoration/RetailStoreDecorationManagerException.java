
package com.doublechaintech.retailscm.retailstoredecoration;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class RetailStoreDecorationManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public RetailStoreDecorationManagerException(String string) {
		super(string);
	}
	public RetailStoreDecorationManagerException(Message message) {
		super(message);
	}
	public RetailStoreDecorationManagerException(List<Message> messageList) {
		super(messageList);
	}

}


