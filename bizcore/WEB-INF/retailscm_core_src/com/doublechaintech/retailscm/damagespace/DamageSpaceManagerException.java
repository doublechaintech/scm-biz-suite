
package com.doublechaintech.retailscm.damagespace;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class DamageSpaceManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public DamageSpaceManagerException(String string) {
		super(string);
	}
	public DamageSpaceManagerException(Message message) {
		super(message);
	}
	public DamageSpaceManagerException(List<Message> messageList) {
		super(messageList);
	}

}


