package com.doublechaintech.retailscm.retailstorecountrycenter;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class RetailStoreCountryCenterVersionChangedException
    extends RetailStoreCountryCenterManagerException {
  private static final long serialVersionUID = 1L;

  public RetailStoreCountryCenterVersionChangedException(String string) {
    super(string);
  }
}
