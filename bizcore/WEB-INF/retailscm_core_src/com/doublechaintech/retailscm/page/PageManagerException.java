
package com.doublechaintech.retailscm.page;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class PageManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public PageManagerException(String string) {
		super(string);
	}
	public PageManagerException(Message message) {
		super(message);
	}
	public PageManagerException(List<Message> messageList) {
		super(messageList);
	}

}


