
package com.doublechaintech.retailscm.consumerorderlineitem;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class ConsumerOrderLineItemManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public ConsumerOrderLineItemManagerException(String string) {
		super(string);
	}
	public ConsumerOrderLineItemManagerException(Message message) {
		super(message);
	}
	public ConsumerOrderLineItemManagerException(List<Message> messageList) {
		super(messageList);
	}

}


