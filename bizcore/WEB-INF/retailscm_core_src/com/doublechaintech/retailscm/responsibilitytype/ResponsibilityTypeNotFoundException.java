package com.doublechaintech.retailscm.responsibilitytype;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class ResponsibilityTypeNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public ResponsibilityTypeNotFoundException(String string) {
    super(string);
  }
}
