
package com.doublechaintech.retailscm.levelonedepartment;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class LevelOneDepartmentManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public LevelOneDepartmentManagerException(String string) {
		super(string);
	}
	public LevelOneDepartmentManagerException(Message message) {
		super(message);
	}
	public LevelOneDepartmentManagerException(List<Message> messageList) {
		super(messageList);
	}

}


