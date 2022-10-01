package com.doublechaintech.retailscm.userdomain;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class UserDomainVersionChangedException extends UserDomainManagerException {
  private static final long serialVersionUID = 1L;

  public UserDomainVersionChangedException(String string) {
    super(string);
  }
}
