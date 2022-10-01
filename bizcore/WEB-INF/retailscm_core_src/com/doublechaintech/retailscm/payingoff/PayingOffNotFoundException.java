package com.doublechaintech.retailscm.payingoff;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class PayingOffNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public PayingOffNotFoundException(String string) {
    super(string);
  }
}
