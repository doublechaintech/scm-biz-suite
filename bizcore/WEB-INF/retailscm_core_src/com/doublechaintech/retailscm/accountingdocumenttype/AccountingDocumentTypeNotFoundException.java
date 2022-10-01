package com.doublechaintech.retailscm.accountingdocumenttype;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class AccountingDocumentTypeNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public AccountingDocumentTypeNotFoundException(String string) {
    super(string);
  }
}
