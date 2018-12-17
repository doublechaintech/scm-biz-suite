
package com.doublechaintech.retailscm.termination;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class TerminationManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public TerminationManagerException(String string) {
		super(string);
	}
	public TerminationManagerException(Message message) {
		super(message);
	}
	public TerminationManagerException(List<Message> messageList) {
		super(messageList);
	}

}


