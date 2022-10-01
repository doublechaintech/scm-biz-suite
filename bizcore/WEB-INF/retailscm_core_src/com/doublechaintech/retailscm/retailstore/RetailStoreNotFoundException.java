package com.doublechaintech.retailscm.retailstore;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class RetailStoreNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public RetailStoreNotFoundException(String string) {
    super(string);
  }
}
