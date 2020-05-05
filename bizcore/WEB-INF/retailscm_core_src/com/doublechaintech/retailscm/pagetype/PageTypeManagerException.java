
package com.doublechaintech.retailscm.pagetype;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class PageTypeManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public PageTypeManagerException(String string) {
		super(string);
	}
	public PageTypeManagerException(Message message) {
		super(message);
	}
	public PageTypeManagerException(List<Message> messageList) {
		super(messageList);
	}

}


