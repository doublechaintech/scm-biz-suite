package com.doublechaintech.retailscm.shippingspace;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class ShippingSpaceVersionChangedException extends ShippingSpaceManagerException {
  private static final long serialVersionUID = 1L;

  public ShippingSpaceVersionChangedException(String string) {
    super(string);
  }
}
