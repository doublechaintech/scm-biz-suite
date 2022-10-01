package com.doublechaintech.retailscm.catalog;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class CatalogVersionChangedException extends CatalogManagerException {
  private static final long serialVersionUID = 1L;

  public CatalogVersionChangedException(String string) {
    super(string);
  }
}
