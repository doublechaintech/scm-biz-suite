
package com.doublechaintech.retailscm.instructor;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class InstructorManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public InstructorManagerException(String string) {
		super(string);
	}
	public InstructorManagerException(Message message) {
		super(message);
	}
	public InstructorManagerException(List<Message> messageList) {
		super(messageList);
	}

}


