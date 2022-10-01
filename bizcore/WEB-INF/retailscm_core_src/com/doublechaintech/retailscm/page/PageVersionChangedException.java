package com.doublechaintech.retailscm.page;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class PageVersionChangedException extends PageManagerException {
  private static final long serialVersionUID = 1L;

  public PageVersionChangedException(String string) {
    super(string);
  }
}
