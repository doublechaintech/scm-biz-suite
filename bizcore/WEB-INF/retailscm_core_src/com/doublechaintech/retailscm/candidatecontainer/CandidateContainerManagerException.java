
package com.doublechaintech.retailscm.candidatecontainer;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class CandidateContainerManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public CandidateContainerManagerException(String string) {
		super(string);
	}
	public CandidateContainerManagerException(Message message) {
		super(message);
	}
	public CandidateContainerManagerException(List<Message> messageList) {
		super(messageList);
	}

}


