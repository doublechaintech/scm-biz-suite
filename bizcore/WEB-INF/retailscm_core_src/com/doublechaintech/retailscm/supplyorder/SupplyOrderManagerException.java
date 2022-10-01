package com.doublechaintech.retailscm.supplyorder;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class SupplyOrderManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public SupplyOrderManagerException(String string) {
    super(string);
  }

  public SupplyOrderManagerException(Message message) {
    super(message);
  }

  public SupplyOrderManagerException(List<Message> messageList) {
    super(messageList);
  }
}
