package com.doublechaintech.retailscm.view;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class ViewVersionChangedException extends ViewManagerException {
  private static final long serialVersionUID = 1L;

  public ViewVersionChangedException(String string) {
    super(string);
  }
}
