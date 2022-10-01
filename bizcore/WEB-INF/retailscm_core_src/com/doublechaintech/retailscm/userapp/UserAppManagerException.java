package com.doublechaintech.retailscm.userapp;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class UserAppManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public UserAppManagerException(String string) {
    super(string);
  }

  public UserAppManagerException(Message message) {
    super(message);
  }

  public UserAppManagerException(List<Message> messageList) {
    super(messageList);
  }
}
