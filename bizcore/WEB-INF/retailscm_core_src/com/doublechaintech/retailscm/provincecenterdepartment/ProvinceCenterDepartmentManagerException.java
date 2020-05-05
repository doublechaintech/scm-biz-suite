
package com.doublechaintech.retailscm.provincecenterdepartment;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class ProvinceCenterDepartmentManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public ProvinceCenterDepartmentManagerException(String string) {
		super(string);
	}
	public ProvinceCenterDepartmentManagerException(Message message) {
		super(message);
	}
	public ProvinceCenterDepartmentManagerException(List<Message> messageList) {
		super(messageList);
	}

}


