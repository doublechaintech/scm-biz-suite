package com.doublechaintech.retailscm.mobileapp;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class MobileAppManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public MobileAppManagerException(String string) {
    super(string);
  }

  public MobileAppManagerException(Message message) {
    super(message);
  }

  public MobileAppManagerException(List<Message> messageList) {
    super(messageList);
  }
}
