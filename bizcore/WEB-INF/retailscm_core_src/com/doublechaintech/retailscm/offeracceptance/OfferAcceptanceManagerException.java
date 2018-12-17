
package com.doublechaintech.retailscm.offeracceptance;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class OfferAcceptanceManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public OfferAcceptanceManagerException(String string) {
		super(string);
	}
	public OfferAcceptanceManagerException(Message message) {
		super(message);
	}
	public OfferAcceptanceManagerException(List<Message> messageList) {
		super(messageList);
	}

}


