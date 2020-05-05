
package com.doublechaintech.retailscm.keypairidentify;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class KeypairIdentifyManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public KeypairIdentifyManagerException(String string) {
		super(string);
	}
	public KeypairIdentifyManagerException(Message message) {
		super(message);
	}
	public KeypairIdentifyManagerException(List<Message> messageList) {
		super(messageList);
	}

}


