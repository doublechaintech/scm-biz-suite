package com.doublechaintech.retailscm.sku;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class SkuManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public SkuManagerException(String string) {
    super(string);
  }

  public SkuManagerException(Message message) {
    super(message);
  }

  public SkuManagerException(List<Message> messageList) {
    super(messageList);
  }
}
