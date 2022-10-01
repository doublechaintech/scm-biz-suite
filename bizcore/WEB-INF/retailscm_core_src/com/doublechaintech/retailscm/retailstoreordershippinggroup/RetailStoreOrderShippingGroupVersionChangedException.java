package com.doublechaintech.retailscm.retailstoreordershippinggroup;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class RetailStoreOrderShippingGroupVersionChangedException
    extends RetailStoreOrderShippingGroupManagerException {
  private static final long serialVersionUID = 1L;

  public RetailStoreOrderShippingGroupVersionChangedException(String string) {
    super(string);
  }
}
