
package com.doublechaintech.retailscm.employeeeducation;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class EmployeeEducationManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public EmployeeEducationManagerException(String string) {
		super(string);
	}
	public EmployeeEducationManagerException(Message message) {
		super(message);
	}
	public EmployeeEducationManagerException(List<Message> messageList) {
		super(messageList);
	}

}


