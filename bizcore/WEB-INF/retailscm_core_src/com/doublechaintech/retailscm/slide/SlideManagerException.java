
package com.doublechaintech.retailscm.slide;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class SlideManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public SlideManagerException(String string) {
		super(string);
	}
	public SlideManagerException(Message message) {
		super(message);
	}
	public SlideManagerException(List<Message> messageList) {
		super(messageList);
	}

}


