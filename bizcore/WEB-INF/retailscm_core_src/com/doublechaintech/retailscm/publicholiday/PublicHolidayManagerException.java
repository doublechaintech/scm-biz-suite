
package com.doublechaintech.retailscm.publicholiday;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class PublicHolidayManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public PublicHolidayManagerException(String string) {
		super(string);
	}
	public PublicHolidayManagerException(Message message) {
		super(message);
	}
	public PublicHolidayManagerException(List<Message> messageList) {
		super(messageList);
	}

}


