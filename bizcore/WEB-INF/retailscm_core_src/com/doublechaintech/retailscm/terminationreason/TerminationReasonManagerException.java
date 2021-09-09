
package com.doublechaintech.retailscm.terminationreason;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class TerminationReasonManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public TerminationReasonManagerException(String string) {
		super(string);
	}
	public TerminationReasonManagerException(Message message) {
		super(message);
	}
	public TerminationReasonManagerException(List<Message> messageList) {
		super(messageList);
	}

}


