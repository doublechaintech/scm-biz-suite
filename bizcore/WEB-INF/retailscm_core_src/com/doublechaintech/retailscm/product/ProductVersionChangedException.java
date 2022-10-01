package com.doublechaintech.retailscm.product;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class ProductVersionChangedException extends ProductManagerException {
  private static final long serialVersionUID = 1L;

  public ProductVersionChangedException(String string) {
    super(string);
  }
}
