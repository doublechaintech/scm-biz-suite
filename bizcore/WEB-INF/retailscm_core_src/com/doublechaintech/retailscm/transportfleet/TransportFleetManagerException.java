
package com.doublechaintech.retailscm.transportfleet;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class TransportFleetManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public TransportFleetManagerException(String string) {
		super(string);
	}
	public TransportFleetManagerException(Message message) {
		super(message);
	}
	public TransportFleetManagerException(List<Message> messageList) {
		super(messageList);
	}

}


