package com.doublechaintech.retailscm.uiaction;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class UiActionVersionChangedException extends UiActionManagerException {
  private static final long serialVersionUID = 1L;

  public UiActionVersionChangedException(String string) {
    super(string);
  }
}
