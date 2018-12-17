
package com.doublechaintech.retailscm.leavetype;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class LeaveTypeManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public LeaveTypeManagerException(String string) {
		super(string);
	}
	public LeaveTypeManagerException(Message message) {
		super(message);
	}
	public LeaveTypeManagerException(List<Message> messageList) {
		super(messageList);
	}

}


