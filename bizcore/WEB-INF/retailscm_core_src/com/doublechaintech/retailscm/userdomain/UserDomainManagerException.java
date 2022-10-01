package com.doublechaintech.retailscm.userdomain;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class UserDomainManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public UserDomainManagerException(String string) {
    super(string);
  }

  public UserDomainManagerException(Message message) {
    super(message);
  }

  public UserDomainManagerException(List<Message> messageList) {
    super(messageList);
  }
}
