package com.doublechaintech.retailscm.accountingdocument;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class AccountingDocumentManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public AccountingDocumentManagerException(String string) {
    super(string);
  }

  public AccountingDocumentManagerException(Message message) {
    super(message);
  }

  public AccountingDocumentManagerException(List<Message> messageList) {
    super(messageList);
  }
}
