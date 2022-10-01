package com.doublechaintech.retailscm.accountingsubject;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class AccountingSubjectVersionChangedException extends AccountingSubjectManagerException {
  private static final long serialVersionUID = 1L;

  public AccountingSubjectVersionChangedException(String string) {
    super(string);
  }
}
