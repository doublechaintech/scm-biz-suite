
package com.doublechaintech.retailscm.consumerordershippinggroup;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class ConsumerOrderShippingGroupManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public ConsumerOrderShippingGroupManagerException(String string) {
		super(string);
	}
	public ConsumerOrderShippingGroupManagerException(Message message) {
		super(message);
	}
	public ConsumerOrderShippingGroupManagerException(List<Message> messageList) {
		super(messageList);
	}

}


