package com.doublechaintech.retailscm.page;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class PageNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public PageNotFoundException(String string) {
    super(string);
  }
}
