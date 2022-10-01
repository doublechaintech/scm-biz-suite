package com.doublechaintech.retailscm.publicholiday;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class PublicHolidayVersionChangedException extends PublicHolidayManagerException {
  private static final long serialVersionUID = 1L;

  public PublicHolidayVersionChangedException(String string) {
    super(string);
  }
}
