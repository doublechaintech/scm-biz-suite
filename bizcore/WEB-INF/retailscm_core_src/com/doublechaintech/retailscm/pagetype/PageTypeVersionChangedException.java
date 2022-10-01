package com.doublechaintech.retailscm.pagetype;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class PageTypeVersionChangedException extends PageTypeManagerException {
  private static final long serialVersionUID = 1L;

  public PageTypeVersionChangedException(String string) {
    super(string);
  }
}
