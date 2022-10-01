package com.doublechaintech.retailscm.sku;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class SkuVersionChangedException extends SkuManagerException {
  private static final long serialVersionUID = 1L;

  public SkuVersionChangedException(String string) {
    super(string);
  }
}
