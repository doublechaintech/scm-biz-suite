package com.doublechaintech.retailscm.payingoff;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class PayingOffVersionChangedException extends PayingOffManagerException {
  private static final long serialVersionUID = 1L;

  public PayingOffVersionChangedException(String string) {
    super(string);
  }
}
