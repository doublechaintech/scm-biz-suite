
package com.doublechaintech.retailscm.wechatminiappidentity;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class WechatMiniappIdentityManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public WechatMiniappIdentityManagerException(String string) {
		super(string);
	}
	public WechatMiniappIdentityManagerException(Message message) {
		super(message);
	}
	public WechatMiniappIdentityManagerException(List<Message> messageList) {
		super(messageList);
	}

}


