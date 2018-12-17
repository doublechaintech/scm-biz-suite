
package com.doublechaintech.retailscm.accountingdocumentauditing;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class AccountingDocumentAuditingManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public AccountingDocumentAuditingManagerException(String string) {
		super(string);
	}
	public AccountingDocumentAuditingManagerException(Message message) {
		super(message);
	}
	public AccountingDocumentAuditingManagerException(List<Message> messageList) {
		super(messageList);
	}

}


