package com.doublechaintech.retailscm.mobileapp;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class MobileAppNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public MobileAppNotFoundException(String string) {
    super(string);
  }
}
