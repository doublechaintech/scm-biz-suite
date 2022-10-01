package com.doublechaintech.retailscm.citypartner;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class CityPartnerVersionChangedException extends CityPartnerManagerException {
  private static final long serialVersionUID = 1L;

  public CityPartnerVersionChangedException(String string) {
    super(string);
  }
}
