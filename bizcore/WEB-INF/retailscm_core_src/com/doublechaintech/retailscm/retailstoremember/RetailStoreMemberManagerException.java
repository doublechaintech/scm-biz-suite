package com.doublechaintech.retailscm.retailstoremember;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class RetailStoreMemberManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public RetailStoreMemberManagerException(String string) {
    super(string);
  }

  public RetailStoreMemberManagerException(Message message) {
    super(message);
  }

  public RetailStoreMemberManagerException(List<Message> messageList) {
    super(messageList);
  }
}
