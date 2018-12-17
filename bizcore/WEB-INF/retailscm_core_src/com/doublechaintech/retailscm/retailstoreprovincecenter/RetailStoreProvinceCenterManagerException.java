
package com.doublechaintech.retailscm.retailstoreprovincecenter;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class RetailStoreProvinceCenterManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public RetailStoreProvinceCenterManagerException(String string) {
		super(string);
	}
	public RetailStoreProvinceCenterManagerException(Message message) {
		super(message);
	}
	public RetailStoreProvinceCenterManagerException(List<Message> messageList) {
		super(messageList);
	}

}


