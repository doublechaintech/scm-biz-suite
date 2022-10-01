package com.doublechaintech.retailscm.provincecenteremployee;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class ProvinceCenterEmployeeManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public ProvinceCenterEmployeeManagerException(String string) {
    super(string);
  }

  public ProvinceCenterEmployeeManagerException(Message message) {
    super(message);
  }

  public ProvinceCenterEmployeeManagerException(List<Message> messageList) {
    super(messageList);
  }
}
