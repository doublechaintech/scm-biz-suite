package com.doublechaintech.retailscm.retailstoremember;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class RetailStoreMemberNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public RetailStoreMemberNotFoundException(String string) {
    super(string);
  }
}
