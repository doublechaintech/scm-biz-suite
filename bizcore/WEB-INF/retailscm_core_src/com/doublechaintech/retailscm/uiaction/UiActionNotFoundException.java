package com.doublechaintech.retailscm.uiaction;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class UiActionNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public UiActionNotFoundException(String string) {
    super(string);
  }
}
