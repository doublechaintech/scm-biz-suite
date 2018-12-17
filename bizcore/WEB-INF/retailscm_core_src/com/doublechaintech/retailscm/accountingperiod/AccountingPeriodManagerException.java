
package com.doublechaintech.retailscm.accountingperiod;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class AccountingPeriodManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public AccountingPeriodManagerException(String string) {
		super(string);
	}
	public AccountingPeriodManagerException(Message message) {
		super(message);
	}
	public AccountingPeriodManagerException(List<Message> messageList) {
		super(messageList);
	}

}


