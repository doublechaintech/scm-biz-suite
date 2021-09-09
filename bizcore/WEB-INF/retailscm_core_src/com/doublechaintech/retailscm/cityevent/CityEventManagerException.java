
package com.doublechaintech.retailscm.cityevent;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class CityEventManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public CityEventManagerException(String string) {
		super(string);
	}
	public CityEventManagerException(Message message) {
		super(message);
	}
	public CityEventManagerException(List<Message> messageList) {
		super(messageList);
	}

}


