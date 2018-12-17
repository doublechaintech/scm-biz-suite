
package com.doublechaintech.retailscm.genericform;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class GenericFormManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public GenericFormManagerException(String string) {
		super(string);
	}
	public GenericFormManagerException(Message message) {
		super(message);
	}
	public GenericFormManagerException(List<Message> messageList) {
		super(messageList);
	}

}


