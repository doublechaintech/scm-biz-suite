
package com.doublechaintech.retailscm.skilltype;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class SkillTypeManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public SkillTypeManagerException(String string) {
		super(string);
	}
	public SkillTypeManagerException(Message message) {
		super(message);
	}
	public SkillTypeManagerException(List<Message> messageList) {
		super(messageList);
	}

}


