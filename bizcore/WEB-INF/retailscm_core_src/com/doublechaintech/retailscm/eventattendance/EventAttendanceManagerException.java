
package com.doublechaintech.retailscm.eventattendance;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class EventAttendanceManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public EventAttendanceManagerException(String string) {
		super(string);
	}
	public EventAttendanceManagerException(Message message) {
		super(message);
	}
	public EventAttendanceManagerException(List<Message> messageList) {
		super(messageList);
	}

}


