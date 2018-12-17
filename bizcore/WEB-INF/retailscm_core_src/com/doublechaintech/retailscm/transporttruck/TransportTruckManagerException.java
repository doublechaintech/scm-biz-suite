
package com.doublechaintech.retailscm.transporttruck;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class TransportTruckManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public TransportTruckManagerException(String string) {
		super(string);
	}
	public TransportTruckManagerException(Message message) {
		super(message);
	}
	public TransportTruckManagerException(List<Message> messageList) {
		super(messageList);
	}

}


