
package com.doublechaintech.retailscm.consumerordershipment;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class ConsumerOrderShipmentManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public ConsumerOrderShipmentManagerException(String string) {
		super(string);
	}
	public ConsumerOrderShipmentManagerException(Message message) {
		super(message);
	}
	public ConsumerOrderShipmentManagerException(List<Message> messageList) {
		super(messageList);
	}

}


