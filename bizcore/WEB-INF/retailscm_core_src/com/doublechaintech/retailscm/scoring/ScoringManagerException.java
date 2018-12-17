
package com.doublechaintech.retailscm.scoring;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class ScoringManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public ScoringManagerException(String string) {
		super(string);
	}
	public ScoringManagerException(Message message) {
		super(message);
	}
	public ScoringManagerException(List<Message> messageList) {
		super(messageList);
	}

}


