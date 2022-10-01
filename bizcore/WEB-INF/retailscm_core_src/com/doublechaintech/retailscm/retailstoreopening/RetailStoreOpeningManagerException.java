package com.doublechaintech.retailscm.retailstoreopening;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class RetailStoreOpeningManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public RetailStoreOpeningManagerException(String string) {
    super(string);
  }

  public RetailStoreOpeningManagerException(Message message) {
    super(message);
  }

  public RetailStoreOpeningManagerException(List<Message> messageList) {
    super(messageList);
  }
}
