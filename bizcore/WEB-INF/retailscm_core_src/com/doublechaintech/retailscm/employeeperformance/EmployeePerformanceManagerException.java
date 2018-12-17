
package com.doublechaintech.retailscm.employeeperformance;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class EmployeePerformanceManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public EmployeePerformanceManagerException(String string) {
		super(string);
	}
	public EmployeePerformanceManagerException(Message message) {
		super(message);
	}
	public EmployeePerformanceManagerException(List<Message> messageList) {
		super(messageList);
	}

}


