
package com.doublechaintech.retailscm.terminationtype;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class TerminationTypeManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public TerminationTypeManagerException(String string) {
		super(string);
	}
	public TerminationTypeManagerException(Message message) {
		super(message);
	}
	public TerminationTypeManagerException(List<Message> messageList) {
		super(messageList);
	}

}


