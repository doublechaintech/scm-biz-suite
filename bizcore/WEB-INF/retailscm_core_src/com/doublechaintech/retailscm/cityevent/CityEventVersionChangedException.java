package com.doublechaintech.retailscm.cityevent;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class CityEventVersionChangedException extends CityEventManagerException {
  private static final long serialVersionUID = 1L;

  public CityEventVersionChangedException(String string) {
    super(string);
  }
}
