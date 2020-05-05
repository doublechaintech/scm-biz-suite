
package com.doublechaintech.retailscm.treenode;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class TreeNodeManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public TreeNodeManagerException(String string) {
		super(string);
	}
	public TreeNodeManagerException(Message message) {
		super(message);
	}
	public TreeNodeManagerException(List<Message> messageList) {
		super(messageList);
	}

}



















