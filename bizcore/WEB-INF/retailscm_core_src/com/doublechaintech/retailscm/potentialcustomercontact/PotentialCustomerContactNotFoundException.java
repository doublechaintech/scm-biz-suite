package com.doublechaintech.retailscm.potentialcustomercontact;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class PotentialCustomerContactNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public PotentialCustomerContactNotFoundException(String string) {
    super(string);
  }
}
