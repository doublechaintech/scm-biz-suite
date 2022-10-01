package com.doublechaintech.retailscm.potentialcustomercontact;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class PotentialCustomerContactVersionChangedException
    extends PotentialCustomerContactManagerException {
  private static final long serialVersionUID = 1L;

  public PotentialCustomerContactVersionChangedException(String string) {
    super(string);
  }
}
