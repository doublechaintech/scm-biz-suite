package com.doublechaintech.retailscm.retailstoreclosing;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class RetailStoreClosingVersionChangedException extends RetailStoreClosingManagerException {
  private static final long serialVersionUID = 1L;

  public RetailStoreClosingVersionChangedException(String string) {
    super(string);
  }
}
