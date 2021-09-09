
package com.doublechaintech.retailscm.keypairidentity;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class KeyPairIdentityManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public KeyPairIdentityManagerException(String string) {
		super(string);
	}
	public KeyPairIdentityManagerException(Message message) {
		super(message);
	}
	public KeyPairIdentityManagerException(List<Message> messageList) {
		super(messageList);
	}

}


