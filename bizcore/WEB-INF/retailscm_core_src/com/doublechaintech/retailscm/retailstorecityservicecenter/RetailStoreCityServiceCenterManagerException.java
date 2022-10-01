package com.doublechaintech.retailscm.retailstorecityservicecenter;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class RetailStoreCityServiceCenterManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public RetailStoreCityServiceCenterManagerException(String string) {
    super(string);
  }

  public RetailStoreCityServiceCenterManagerException(Message message) {
    super(message);
  }

  public RetailStoreCityServiceCenterManagerException(List<Message> messageList) {
    super(messageList);
  }
}
