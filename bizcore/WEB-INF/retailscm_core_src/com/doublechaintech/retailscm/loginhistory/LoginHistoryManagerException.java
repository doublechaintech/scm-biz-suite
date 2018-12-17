
package com.doublechaintech.retailscm.loginhistory;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class LoginHistoryManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public LoginHistoryManagerException(String string) {
		super(string);
	}
	public LoginHistoryManagerException(Message message) {
		super(message);
	}
	public LoginHistoryManagerException(List<Message> messageList) {
		super(messageList);
	}

}


