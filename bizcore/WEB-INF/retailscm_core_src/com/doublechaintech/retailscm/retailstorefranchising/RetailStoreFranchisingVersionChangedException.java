package com.doublechaintech.retailscm.retailstorefranchising;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class RetailStoreFranchisingVersionChangedException
    extends RetailStoreFranchisingManagerException {
  private static final long serialVersionUID = 1L;

  public RetailStoreFranchisingVersionChangedException(String string) {
    super(string);
  }
}
