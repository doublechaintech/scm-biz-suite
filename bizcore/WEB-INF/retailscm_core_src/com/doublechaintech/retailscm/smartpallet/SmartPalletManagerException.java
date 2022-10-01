package com.doublechaintech.retailscm.smartpallet;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class SmartPalletManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public SmartPalletManagerException(String string) {
    super(string);
  }

  public SmartPalletManagerException(Message message) {
    super(message);
  }

  public SmartPalletManagerException(List<Message> messageList) {
    super(messageList);
  }
}
