
package com.doublechaintech.retailscm.section;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class SectionManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public SectionManagerException(String string) {
		super(string);
	}
	public SectionManagerException(Message message) {
		super(message);
	}
	public SectionManagerException(List<Message> messageList) {
		super(messageList);
	}

}


