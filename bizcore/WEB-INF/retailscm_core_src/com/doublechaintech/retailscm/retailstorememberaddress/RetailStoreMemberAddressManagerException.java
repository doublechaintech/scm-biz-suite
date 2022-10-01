package com.doublechaintech.retailscm.retailstorememberaddress;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class RetailStoreMemberAddressManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public RetailStoreMemberAddressManagerException(String string) {
    super(string);
  }

  public RetailStoreMemberAddressManagerException(Message message) {
    super(message);
  }

  public RetailStoreMemberAddressManagerException(List<Message> messageList) {
    super(messageList);
  }
}
