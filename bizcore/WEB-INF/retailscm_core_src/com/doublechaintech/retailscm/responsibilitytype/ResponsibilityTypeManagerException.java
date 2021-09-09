
package com.doublechaintech.retailscm.responsibilitytype;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class ResponsibilityTypeManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public ResponsibilityTypeManagerException(String string) {
		super(string);
	}
	public ResponsibilityTypeManagerException(Message message) {
		super(message);
	}
	public ResponsibilityTypeManagerException(List<Message> messageList) {
		super(messageList);
	}

}


