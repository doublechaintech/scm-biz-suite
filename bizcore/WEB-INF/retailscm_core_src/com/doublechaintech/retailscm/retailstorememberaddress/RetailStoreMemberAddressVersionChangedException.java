package com.doublechaintech.retailscm.retailstorememberaddress;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class RetailStoreMemberAddressVersionChangedException
    extends RetailStoreMemberAddressManagerException {
  private static final long serialVersionUID = 1L;

  public RetailStoreMemberAddressVersionChangedException(String string) {
    super(string);
  }
}
