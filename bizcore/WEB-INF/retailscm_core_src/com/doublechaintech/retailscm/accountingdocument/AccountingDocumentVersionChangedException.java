package com.doublechaintech.retailscm.accountingdocument;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class AccountingDocumentVersionChangedException extends AccountingDocumentManagerException {
  private static final long serialVersionUID = 1L;

  public AccountingDocumentVersionChangedException(String string) {
    super(string);
  }
}
