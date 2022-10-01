package com.doublechaintech.retailscm.responsibilitytype;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class ResponsibilityTypeVersionChangedException extends ResponsibilityTypeManagerException {
  private static final long serialVersionUID = 1L;

  public ResponsibilityTypeVersionChangedException(String string) {
    super(string);
  }
}
