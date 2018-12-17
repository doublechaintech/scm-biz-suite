
package com.doublechaintech.retailscm.warehouse;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class WarehouseManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public WarehouseManagerException(String string) {
		super(string);
	}
	public WarehouseManagerException(Message message) {
		super(message);
	}
	public WarehouseManagerException(List<Message> messageList) {
		super(messageList);
	}

}


