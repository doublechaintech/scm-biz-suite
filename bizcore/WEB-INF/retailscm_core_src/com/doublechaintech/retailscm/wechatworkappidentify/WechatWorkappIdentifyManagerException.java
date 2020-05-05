
package com.doublechaintech.retailscm.wechatworkappidentify;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class WechatWorkappIdentifyManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public WechatWorkappIdentifyManagerException(String string) {
		super(string);
	}
	public WechatWorkappIdentifyManagerException(Message message) {
		super(message);
	}
	public WechatWorkappIdentifyManagerException(List<Message> messageList) {
		super(messageList);
	}

}


