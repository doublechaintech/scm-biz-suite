
package com.doublechaintech.retailscm.jobapplication;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class JobApplicationManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public JobApplicationManagerException(String string) {
		super(string);
	}
	public JobApplicationManagerException(Message message) {
		super(message);
	}
	public JobApplicationManagerException(List<Message> messageList) {
		super(messageList);
	}

}


