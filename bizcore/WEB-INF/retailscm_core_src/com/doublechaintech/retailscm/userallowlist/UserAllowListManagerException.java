package com.doublechaintech.retailscm.userallowlist;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class UserAllowListManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public UserAllowListManagerException(String string) {
    super(string);
  }

  public UserAllowListManagerException(Message message) {
    super(message);
  }

  public UserAllowListManagerException(List<Message> messageList) {
    super(messageList);
  }
}
