package com.doublechaintech.retailscm.payingoff;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class PayingOffManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public PayingOffManagerException(String string) {
    super(string);
  }

  public PayingOffManagerException(Message message) {
    super(message);
  }

  public PayingOffManagerException(List<Message> messageList) {
    super(messageList);
  }
}
