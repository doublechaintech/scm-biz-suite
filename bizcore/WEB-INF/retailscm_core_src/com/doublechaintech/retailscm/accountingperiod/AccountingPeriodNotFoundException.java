package com.doublechaintech.retailscm.accountingperiod;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class AccountingPeriodNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public AccountingPeriodNotFoundException(String string) {
    super(string);
  }
}
