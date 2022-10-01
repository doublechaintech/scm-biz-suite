package com.doublechaintech.retailscm.mobileapp;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class MobileAppVersionChangedException extends MobileAppManagerException {
  private static final long serialVersionUID = 1L;

  public MobileAppVersionChangedException(String string) {
    super(string);
  }
}
