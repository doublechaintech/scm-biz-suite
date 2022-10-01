package com.doublechaintech.retailscm.accountingdocumentline;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class AccountingDocumentLineManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public AccountingDocumentLineManagerException(String string) {
    super(string);
  }

  public AccountingDocumentLineManagerException(Message message) {
    super(message);
  }

  public AccountingDocumentLineManagerException(List<Message> messageList) {
    super(messageList);
  }
}
