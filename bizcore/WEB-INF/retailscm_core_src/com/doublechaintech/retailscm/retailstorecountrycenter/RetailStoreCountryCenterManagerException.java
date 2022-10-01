package com.doublechaintech.retailscm.retailstorecountrycenter;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class RetailStoreCountryCenterManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public RetailStoreCountryCenterManagerException(String string) {
    super(string);
  }

  public RetailStoreCountryCenterManagerException(Message message) {
    super(message);
  }

  public RetailStoreCountryCenterManagerException(List<Message> messageList) {
    super(messageList);
  }
}
