
package com.doublechaintech.retailscm.employeeinterview;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class EmployeeInterviewManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public EmployeeInterviewManagerException(String string) {
		super(string);
	}
	public EmployeeInterviewManagerException(Message message) {
		super(message);
	}
	public EmployeeInterviewManagerException(List<Message> messageList) {
		super(messageList);
	}

}


