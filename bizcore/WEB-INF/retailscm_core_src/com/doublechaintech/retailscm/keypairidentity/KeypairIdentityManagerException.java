
package com.doublechaintech.retailscm.keypairidentity;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class KeypairIdentityManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public KeypairIdentityManagerException(String string) {
		super(string);
	}
	public KeypairIdentityManagerException(Message message) {
		super(message);
	}
	public KeypairIdentityManagerException(List<Message> messageList) {
		super(messageList);
	}

}


