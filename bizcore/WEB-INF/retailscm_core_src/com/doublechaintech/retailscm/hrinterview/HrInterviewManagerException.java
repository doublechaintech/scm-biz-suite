
package com.doublechaintech.retailscm.hrinterview;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class HrInterviewManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public HrInterviewManagerException(String string) {
		super(string);
	}
	public HrInterviewManagerException(Message message) {
		super(message);
	}
	public HrInterviewManagerException(List<Message> messageList) {
		super(messageList);
	}

}


