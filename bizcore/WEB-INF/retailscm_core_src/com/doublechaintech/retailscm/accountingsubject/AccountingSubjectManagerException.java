
package com.doublechaintech.retailscm.accountingsubject;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class AccountingSubjectManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public AccountingSubjectManagerException(String string) {
		super(string);
	}
	public AccountingSubjectManagerException(Message message) {
		super(message);
	}
	public AccountingSubjectManagerException(List<Message> messageList) {
		super(messageList);
	}

}


