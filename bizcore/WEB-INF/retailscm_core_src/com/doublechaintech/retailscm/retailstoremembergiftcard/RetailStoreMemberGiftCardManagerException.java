
package com.doublechaintech.retailscm.retailstoremembergiftcard;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class RetailStoreMemberGiftCardManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public RetailStoreMemberGiftCardManagerException(String string) {
		super(string);
	}
	public RetailStoreMemberGiftCardManagerException(Message message) {
		super(message);
	}
	public RetailStoreMemberGiftCardManagerException(List<Message> messageList) {
		super(messageList);
	}

}


