package com.doublechaintech.retailscm.slide;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class SlideVersionChangedException extends SlideManagerException {
  private static final long serialVersionUID = 1L;

  public SlideVersionChangedException(String string) {
    super(string);
  }
}
