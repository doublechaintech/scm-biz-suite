package com.doublechaintech.retailscm.retailstoreprovincecenter;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class RetailStoreProvinceCenterVersionChangedException
    extends RetailStoreProvinceCenterManagerException {
  private static final long serialVersionUID = 1L;

  public RetailStoreProvinceCenterVersionChangedException(String string) {
    super(string);
  }
}
