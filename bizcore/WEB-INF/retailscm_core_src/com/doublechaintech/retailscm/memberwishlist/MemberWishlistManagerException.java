package com.doublechaintech.retailscm.memberwishlist;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class MemberWishlistManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public MemberWishlistManagerException(String string) {
    super(string);
  }

  public MemberWishlistManagerException(Message message) {
    super(message);
  }

  public MemberWishlistManagerException(List<Message> messageList) {
    super(messageList);
  }
}
