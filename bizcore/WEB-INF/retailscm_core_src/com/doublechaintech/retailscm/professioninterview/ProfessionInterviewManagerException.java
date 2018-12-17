
package com.doublechaintech.retailscm.professioninterview;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class ProfessionInterviewManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public ProfessionInterviewManagerException(String string) {
		super(string);
	}
	public ProfessionInterviewManagerException(Message message) {
		super(message);
	}
	public ProfessionInterviewManagerException(List<Message> messageList) {
		super(messageList);
	}

}


