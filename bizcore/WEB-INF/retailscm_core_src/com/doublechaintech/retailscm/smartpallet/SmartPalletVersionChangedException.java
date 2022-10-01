package com.doublechaintech.retailscm.smartpallet;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class SmartPalletVersionChangedException extends SmartPalletManagerException {
  private static final long serialVersionUID = 1L;

  public SmartPalletVersionChangedException(String string) {
    super(string);
  }
}
