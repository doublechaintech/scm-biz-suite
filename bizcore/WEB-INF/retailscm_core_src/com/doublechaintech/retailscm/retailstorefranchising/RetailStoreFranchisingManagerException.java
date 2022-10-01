package com.doublechaintech.retailscm.retailstorefranchising;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class RetailStoreFranchisingManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public RetailStoreFranchisingManagerException(String string) {
    super(string);
  }

  public RetailStoreFranchisingManagerException(Message message) {
    super(message);
  }

  public RetailStoreFranchisingManagerException(List<Message> messageList) {
    super(messageList);
  }
}
