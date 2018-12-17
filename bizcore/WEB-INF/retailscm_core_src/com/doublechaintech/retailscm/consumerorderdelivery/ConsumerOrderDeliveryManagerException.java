
package com.doublechaintech.retailscm.consumerorderdelivery;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class ConsumerOrderDeliveryManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public ConsumerOrderDeliveryManagerException(String string) {
		super(string);
	}
	public ConsumerOrderDeliveryManagerException(Message message) {
		super(message);
	}
	public ConsumerOrderDeliveryManagerException(List<Message> messageList) {
		super(messageList);
	}

}


