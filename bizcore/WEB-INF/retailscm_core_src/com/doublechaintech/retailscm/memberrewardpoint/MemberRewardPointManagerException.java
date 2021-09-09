
package com.doublechaintech.retailscm.memberrewardpoint;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class MemberRewardPointManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public MemberRewardPointManagerException(String string) {
		super(string);
	}
	public MemberRewardPointManagerException(Message message) {
		super(message);
	}
	public MemberRewardPointManagerException(List<Message> messageList) {
		super(messageList);
	}

}


