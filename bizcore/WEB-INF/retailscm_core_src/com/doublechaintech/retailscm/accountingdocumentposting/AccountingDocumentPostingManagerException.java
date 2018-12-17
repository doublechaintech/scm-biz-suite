
package com.doublechaintech.retailscm.accountingdocumentposting;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class AccountingDocumentPostingManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public AccountingDocumentPostingManagerException(String string) {
		super(string);
	}
	public AccountingDocumentPostingManagerException(Message message) {
		super(message);
	}
	public AccountingDocumentPostingManagerException(List<Message> messageList) {
		super(messageList);
	}

}


