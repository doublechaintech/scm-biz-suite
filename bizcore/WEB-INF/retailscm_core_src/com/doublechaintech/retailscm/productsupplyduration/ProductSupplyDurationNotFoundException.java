package com.doublechaintech.retailscm.productsupplyduration;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class ProductSupplyDurationNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public ProductSupplyDurationNotFoundException(String string) {
    super(string);
  }
}
