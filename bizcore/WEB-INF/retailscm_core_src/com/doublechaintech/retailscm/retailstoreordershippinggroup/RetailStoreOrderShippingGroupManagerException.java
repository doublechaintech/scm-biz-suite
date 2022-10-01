package com.doublechaintech.retailscm.retailstoreordershippinggroup;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class RetailStoreOrderShippingGroupManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public RetailStoreOrderShippingGroupManagerException(String string) {
    super(string);
  }

  public RetailStoreOrderShippingGroupManagerException(Message message) {
    super(message);
  }

  public RetailStoreOrderShippingGroupManagerException(List<Message> messageList) {
    super(messageList);
  }
}
