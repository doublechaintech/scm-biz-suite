package com.doublechaintech.retailscm.accountingdocumentline;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class AccountingDocumentLineVersionChangedException
    extends AccountingDocumentLineManagerException {
  private static final long serialVersionUID = 1L;

  public AccountingDocumentLineVersionChangedException(String string) {
    super(string);
  }
}
