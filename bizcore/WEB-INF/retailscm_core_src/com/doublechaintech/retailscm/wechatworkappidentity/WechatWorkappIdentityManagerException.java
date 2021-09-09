
package com.doublechaintech.retailscm.wechatworkappidentity;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class WechatWorkappIdentityManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public WechatWorkappIdentityManagerException(String string) {
		super(string);
	}
	public WechatWorkappIdentityManagerException(Message message) {
		super(message);
	}
	public WechatWorkappIdentityManagerException(List<Message> messageList) {
		super(messageList);
	}

}


