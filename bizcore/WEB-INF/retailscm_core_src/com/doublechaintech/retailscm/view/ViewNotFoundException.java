package com.doublechaintech.retailscm.view;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class ViewNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public ViewNotFoundException(String string) {
    super(string);
  }
}
