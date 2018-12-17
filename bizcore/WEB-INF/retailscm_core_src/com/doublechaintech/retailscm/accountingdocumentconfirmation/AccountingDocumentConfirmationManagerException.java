
package com.doublechaintech.retailscm.accountingdocumentconfirmation;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class AccountingDocumentConfirmationManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public AccountingDocumentConfirmationManagerException(String string) {
		super(string);
	}
	public AccountingDocumentConfirmationManagerException(Message message) {
		super(message);
	}
	public AccountingDocumentConfirmationManagerException(List<Message> messageList) {
		super(messageList);
	}

}


