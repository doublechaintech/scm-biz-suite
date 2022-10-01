package com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class RetailStoreMemberGiftCardConsumeRecordManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public RetailStoreMemberGiftCardConsumeRecordManagerException(String string) {
    super(string);
  }

  public RetailStoreMemberGiftCardConsumeRecordManagerException(Message message) {
    super(message);
  }

  public RetailStoreMemberGiftCardConsumeRecordManagerException(List<Message> messageList) {
    super(messageList);
  }
}
