
package com.doublechaintech.retailscm.consumerorderprocessing;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class ConsumerOrderProcessingManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public ConsumerOrderProcessingManagerException(String string) {
		super(string);
	}
	public ConsumerOrderProcessingManagerException(Message message) {
		super(message);
	}
	public ConsumerOrderProcessingManagerException(List<Message> messageList) {
		super(messageList);
	}

}


