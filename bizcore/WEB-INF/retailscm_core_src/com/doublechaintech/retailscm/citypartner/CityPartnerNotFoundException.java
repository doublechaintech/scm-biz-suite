package com.doublechaintech.retailscm.citypartner;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class CityPartnerNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public CityPartnerNotFoundException(String string) {
    super(string);
  }
}
