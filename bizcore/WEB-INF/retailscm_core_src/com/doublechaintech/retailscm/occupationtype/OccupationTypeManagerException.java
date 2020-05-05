
package com.doublechaintech.retailscm.occupationtype;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class OccupationTypeManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public OccupationTypeManagerException(String string) {
		super(string);
	}
	public OccupationTypeManagerException(Message message) {
		super(message);
	}
	public OccupationTypeManagerException(List<Message> messageList) {
		super(messageList);
	}

}


