package com.doublechaintech.retailscm.receivingspace;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class ReceivingSpaceManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public ReceivingSpaceManagerException(String string) {
    super(string);
  }

  public ReceivingSpaceManagerException(Message message) {
    super(message);
  }

  public ReceivingSpaceManagerException(List<Message> messageList) {
    super(messageList);
  }
}
