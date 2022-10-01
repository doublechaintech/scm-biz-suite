package com.doublechaintech.retailscm.supplyorderpaymentgroup;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class SupplyOrderPaymentGroupManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public SupplyOrderPaymentGroupManagerException(String string) {
    super(string);
  }

  public SupplyOrderPaymentGroupManagerException(Message message) {
    super(message);
  }

  public SupplyOrderPaymentGroupManagerException(List<Message> messageList) {
    super(messageList);
  }
}
