
package com.doublechaintech.retailscm.consumerorderconfirmation;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class ConsumerOrderConfirmationManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public ConsumerOrderConfirmationManagerException(String string) {
		super(string);
	}
	public ConsumerOrderConfirmationManagerException(Message message) {
		super(message);
	}
	public ConsumerOrderConfirmationManagerException(List<Message> messageList) {
		super(messageList);
	}

}


