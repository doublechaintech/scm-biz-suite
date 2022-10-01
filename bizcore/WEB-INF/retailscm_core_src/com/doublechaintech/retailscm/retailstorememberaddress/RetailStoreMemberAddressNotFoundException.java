package com.doublechaintech.retailscm.retailstorememberaddress;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class RetailStoreMemberAddressNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public RetailStoreMemberAddressNotFoundException(String string) {
    super(string);
  }
}
