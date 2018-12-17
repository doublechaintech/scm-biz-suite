
package com.doublechaintech.retailscm.memberrewardpointredemption;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class MemberRewardPointRedemptionManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public MemberRewardPointRedemptionManagerException(String string) {
		super(string);
	}
	public MemberRewardPointRedemptionManagerException(Message message) {
		super(message);
	}
	public MemberRewardPointRedemptionManagerException(List<Message> messageList) {
		super(messageList);
	}

}


