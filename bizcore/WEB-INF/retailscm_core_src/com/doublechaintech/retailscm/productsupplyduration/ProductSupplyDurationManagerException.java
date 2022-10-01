package com.doublechaintech.retailscm.productsupplyduration;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class ProductSupplyDurationManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public ProductSupplyDurationManagerException(String string) {
    super(string);
  }

  public ProductSupplyDurationManagerException(Message message) {
    super(message);
  }

  public ProductSupplyDurationManagerException(List<Message> messageList) {
    super(messageList);
  }
}
