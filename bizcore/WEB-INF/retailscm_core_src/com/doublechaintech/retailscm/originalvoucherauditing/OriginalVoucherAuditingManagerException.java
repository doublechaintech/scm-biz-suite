
package com.doublechaintech.retailscm.originalvoucherauditing;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class OriginalVoucherAuditingManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public OriginalVoucherAuditingManagerException(String string) {
		super(string);
	}
	public OriginalVoucherAuditingManagerException(Message message) {
		super(message);
	}
	public OriginalVoucherAuditingManagerException(List<Message> messageList) {
		super(messageList);
	}

}


