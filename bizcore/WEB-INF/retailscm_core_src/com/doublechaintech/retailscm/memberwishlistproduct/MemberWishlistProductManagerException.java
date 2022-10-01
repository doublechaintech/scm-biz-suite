package com.doublechaintech.retailscm.memberwishlistproduct;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class MemberWishlistProductManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public MemberWishlistProductManagerException(String string) {
    super(string);
  }

  public MemberWishlistProductManagerException(Message message) {
    super(message);
  }

  public MemberWishlistProductManagerException(List<Message> messageList) {
    super(messageList);
  }
}
