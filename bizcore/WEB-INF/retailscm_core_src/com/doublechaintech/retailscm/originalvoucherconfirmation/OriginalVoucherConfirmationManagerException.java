
package com.doublechaintech.retailscm.originalvoucherconfirmation;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class OriginalVoucherConfirmationManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public OriginalVoucherConfirmationManagerException(String string) {
		super(string);
	}
	public OriginalVoucherConfirmationManagerException(Message message) {
		super(message);
	}
	public OriginalVoucherConfirmationManagerException(List<Message> messageList) {
		super(messageList);
	}

}


