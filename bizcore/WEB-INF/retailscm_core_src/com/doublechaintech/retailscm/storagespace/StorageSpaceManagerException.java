
package com.doublechaintech.retailscm.storagespace;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class StorageSpaceManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public StorageSpaceManagerException(String string) {
		super(string);
	}
	public StorageSpaceManagerException(Message message) {
		super(message);
	}
	public StorageSpaceManagerException(List<Message> messageList) {
		super(messageList);
	}

}


