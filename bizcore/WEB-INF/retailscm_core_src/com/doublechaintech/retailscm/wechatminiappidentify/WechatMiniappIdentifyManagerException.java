
package com.doublechaintech.retailscm.wechatminiappidentify;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class WechatMiniappIdentifyManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public WechatMiniappIdentifyManagerException(String string) {
		super(string);
	}
	public WechatMiniappIdentifyManagerException(Message message) {
		super(message);
	}
	public WechatMiniappIdentifyManagerException(List<Message> messageList) {
		super(messageList);
	}

}


