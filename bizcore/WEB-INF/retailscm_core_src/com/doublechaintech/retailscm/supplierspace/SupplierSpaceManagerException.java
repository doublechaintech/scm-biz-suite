package com.doublechaintech.retailscm.supplierspace;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class SupplierSpaceManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public SupplierSpaceManagerException(String string) {
    super(string);
  }

  public SupplierSpaceManagerException(Message message) {
    super(message);
  }

  public SupplierSpaceManagerException(List<Message> messageList) {
    super(messageList);
  }
}
