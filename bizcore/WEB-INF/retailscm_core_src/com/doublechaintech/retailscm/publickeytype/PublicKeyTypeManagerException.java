
package com.doublechaintech.retailscm.publickeytype;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class PublicKeyTypeManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public PublicKeyTypeManagerException(String string) {
		super(string);
	}
	public PublicKeyTypeManagerException(Message message) {
		super(message);
	}
	public PublicKeyTypeManagerException(List<Message> messageList) {
		super(messageList);
	}

}


