
package com.doublechaintech.retailscm.accountingdocumentcreation;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class AccountingDocumentCreationManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public AccountingDocumentCreationManagerException(String string) {
		super(string);
	}
	public AccountingDocumentCreationManagerException(Message message) {
		super(message);
	}
	public AccountingDocumentCreationManagerException(List<Message> messageList) {
		super(messageList);
	}

}


