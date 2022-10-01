package com.doublechaintech.retailscm.slide;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class SlideNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public SlideNotFoundException(String string) {
    super(string);
  }
}
