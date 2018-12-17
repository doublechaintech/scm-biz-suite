
package com.doublechaintech.retailscm.originalvouchercreation;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class OriginalVoucherCreationManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public OriginalVoucherCreationManagerException(String string) {
		super(string);
	}
	public OriginalVoucherCreationManagerException(Message message) {
		super(message);
	}
	public OriginalVoucherCreationManagerException(List<Message> messageList) {
		super(messageList);
	}

}


