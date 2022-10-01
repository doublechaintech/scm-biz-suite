package com.doublechaintech.retailscm.consumerorder;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class ConsumerOrderManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public ConsumerOrderManagerException(String string) {
    super(string);
  }

  public ConsumerOrderManagerException(Message message) {
    super(message);
  }

  public ConsumerOrderManagerException(List<Message> messageList) {
    super(messageList);
  }
}
