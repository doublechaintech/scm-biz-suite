package com.doublechaintech.retailscm.catalog;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class CatalogNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public CatalogNotFoundException(String string) {
    super(string);
  }
}
