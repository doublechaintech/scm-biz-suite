package com.doublechaintech.retailscm.supplyorderlineitem;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class SupplyOrderLineItemManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public SupplyOrderLineItemManagerException(String string) {
    super(string);
  }

  public SupplyOrderLineItemManagerException(Message message) {
    super(message);
  }

  public SupplyOrderLineItemManagerException(List<Message> messageList) {
    super(messageList);
  }
}
