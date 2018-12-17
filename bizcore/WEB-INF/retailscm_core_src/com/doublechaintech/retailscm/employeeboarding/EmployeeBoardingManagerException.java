
package com.doublechaintech.retailscm.employeeboarding;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class EmployeeBoardingManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public EmployeeBoardingManagerException(String string) {
		super(string);
	}
	public EmployeeBoardingManagerException(Message message) {
		super(message);
	}
	public EmployeeBoardingManagerException(List<Message> messageList) {
		super(messageList);
	}

}


