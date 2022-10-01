package com.doublechaintech.retailscm.uiaction;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class UiActionManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public UiActionManagerException(String string) {
    super(string);
  }

  public UiActionManagerException(Message message) {
    super(message);
  }

  public UiActionManagerException(List<Message> messageList) {
    super(messageList);
  }
}
