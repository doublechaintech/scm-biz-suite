package com.doublechaintech.retailscm.accountingdocumenttype;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class AccountingDocumentTypeManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public AccountingDocumentTypeManagerException(String string) {
    super(string);
  }

  public AccountingDocumentTypeManagerException(Message message) {
    super(message);
  }

  public AccountingDocumentTypeManagerException(List<Message> messageList) {
    super(messageList);
  }
}
