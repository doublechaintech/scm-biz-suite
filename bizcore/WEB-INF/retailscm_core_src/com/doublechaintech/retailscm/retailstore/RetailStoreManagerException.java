package com.doublechaintech.retailscm.retailstore;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class RetailStoreManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public RetailStoreManagerException(String string) {
    super(string);
  }

  public RetailStoreManagerException(Message message) {
    super(message);
  }

  public RetailStoreManagerException(List<Message> messageList) {
    super(messageList);
  }
}
