package com.doublechaintech.retailscm.potentialcustomer;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class PotentialCustomerNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public PotentialCustomerNotFoundException(String string) {
    super(string);
  }
}
