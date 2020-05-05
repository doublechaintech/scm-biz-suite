
package com.doublechaintech.retailscm.originalvoucher;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class OriginalVoucherManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public OriginalVoucherManagerException(String string) {
		super(string);
	}
	public OriginalVoucherManagerException(Message message) {
		super(message);
	}
	public OriginalVoucherManagerException(List<Message> messageList) {
		super(messageList);
	}

}


