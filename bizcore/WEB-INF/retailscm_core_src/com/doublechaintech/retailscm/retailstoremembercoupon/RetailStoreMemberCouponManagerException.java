
package com.doublechaintech.retailscm.retailstoremembercoupon;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class RetailStoreMemberCouponManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public RetailStoreMemberCouponManagerException(String string) {
		super(string);
	}
	public RetailStoreMemberCouponManagerException(Message message) {
		super(message);
	}
	public RetailStoreMemberCouponManagerException(List<Message> messageList) {
		super(messageList);
	}

}


