package com.doublechaintech.retailscm.consumerorderpaymentgroup;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class ConsumerOrderPaymentGroupManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public ConsumerOrderPaymentGroupManagerException(String string) {
    super(string);
  }

  public ConsumerOrderPaymentGroupManagerException(Message message) {
    super(message);
  }

  public ConsumerOrderPaymentGroupManagerException(List<Message> messageList) {
    super(messageList);
  }
}
