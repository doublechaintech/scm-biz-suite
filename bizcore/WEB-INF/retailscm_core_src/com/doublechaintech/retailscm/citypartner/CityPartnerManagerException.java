
package com.doublechaintech.retailscm.citypartner;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class CityPartnerManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public CityPartnerManagerException(String string) {
		super(string);
	}
	public CityPartnerManagerException(Message message) {
		super(message);
	}
	public CityPartnerManagerException(List<Message> messageList) {
		super(messageList);
	}

}


