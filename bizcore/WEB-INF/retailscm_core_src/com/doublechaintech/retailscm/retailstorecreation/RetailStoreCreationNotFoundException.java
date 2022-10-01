package com.doublechaintech.retailscm.retailstorecreation;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class RetailStoreCreationNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public RetailStoreCreationNotFoundException(String string) {
    super(string);
  }
}
