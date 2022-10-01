package com.doublechaintech.retailscm.section;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class SectionVersionChangedException extends SectionManagerException {
  private static final long serialVersionUID = 1L;

  public SectionVersionChangedException(String string) {
    super(string);
  }
}
