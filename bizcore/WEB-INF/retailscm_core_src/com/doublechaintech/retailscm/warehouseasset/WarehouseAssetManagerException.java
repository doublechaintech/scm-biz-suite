
package com.doublechaintech.retailscm.warehouseasset;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class WarehouseAssetManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public WarehouseAssetManagerException(String string) {
		super(string);
	}
	public WarehouseAssetManagerException(Message message) {
		super(message);
	}
	public WarehouseAssetManagerException(List<Message> messageList) {
		super(messageList);
	}

}


