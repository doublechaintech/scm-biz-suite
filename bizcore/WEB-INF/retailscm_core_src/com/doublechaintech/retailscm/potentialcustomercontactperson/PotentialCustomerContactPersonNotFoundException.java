package com.doublechaintech.retailscm.potentialcustomercontactperson;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class PotentialCustomerContactPersonNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public PotentialCustomerContactPersonNotFoundException(String string) {
    super(string);
  }
}
