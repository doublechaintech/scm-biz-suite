
package com.doublechaintech.retailscm.truckdriver;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class TruckDriverManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public TruckDriverManagerException(String string) {
		super(string);
	}
	public TruckDriverManagerException(Message message) {
		super(message);
	}
	public TruckDriverManagerException(List<Message> messageList) {
		super(messageList);
	}

}


