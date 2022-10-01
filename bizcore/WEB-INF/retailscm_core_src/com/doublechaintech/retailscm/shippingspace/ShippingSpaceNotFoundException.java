package com.doublechaintech.retailscm.shippingspace;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class ShippingSpaceNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public ShippingSpaceNotFoundException(String string) {
    super(string);
  }
}
