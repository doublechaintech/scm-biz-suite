
package com.doublechaintech.retailscm.retailstoreinvestmentinvitation;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class RetailStoreInvestmentInvitationManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public RetailStoreInvestmentInvitationManagerException(String string) {
		super(string);
	}
	public RetailStoreInvestmentInvitationManagerException(Message message) {
		super(message);
	}
	public RetailStoreInvestmentInvitationManagerException(List<Message> messageList) {
		super(messageList);
	}

}


