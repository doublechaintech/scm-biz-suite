package com.doublechaintech.retailscm.retailstore;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class RetailStoreVersionChangedException extends RetailStoreManagerException {
  private static final long serialVersionUID = 1L;

  public RetailStoreVersionChangedException(String string) {
    super(string);
  }
}
