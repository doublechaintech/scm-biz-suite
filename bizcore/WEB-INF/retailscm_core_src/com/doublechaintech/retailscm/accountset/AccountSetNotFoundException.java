package com.doublechaintech.retailscm.accountset;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class AccountSetNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public AccountSetNotFoundException(String string) {
    super(string);
  }
}
