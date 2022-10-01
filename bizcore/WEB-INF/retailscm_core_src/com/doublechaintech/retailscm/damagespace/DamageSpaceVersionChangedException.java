package com.doublechaintech.retailscm.damagespace;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class DamageSpaceVersionChangedException extends DamageSpaceManagerException {
  private static final long serialVersionUID = 1L;

  public DamageSpaceVersionChangedException(String string) {
    super(string);
  }
}
