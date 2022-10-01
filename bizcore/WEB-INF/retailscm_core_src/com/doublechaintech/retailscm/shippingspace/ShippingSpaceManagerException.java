package com.doublechaintech.retailscm.shippingspace;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class ShippingSpaceManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public ShippingSpaceManagerException(String string) {
    super(string);
  }

  public ShippingSpaceManagerException(Message message) {
    super(message);
  }

  public ShippingSpaceManagerException(List<Message> messageList) {
    super(messageList);
  }
}
