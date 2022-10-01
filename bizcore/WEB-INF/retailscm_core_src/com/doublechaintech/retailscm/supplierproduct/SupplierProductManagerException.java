package com.doublechaintech.retailscm.supplierproduct;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class SupplierProductManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public SupplierProductManagerException(String string) {
    super(string);
  }

  public SupplierProductManagerException(Message message) {
    super(message);
  }

  public SupplierProductManagerException(List<Message> messageList) {
    super(messageList);
  }
}
