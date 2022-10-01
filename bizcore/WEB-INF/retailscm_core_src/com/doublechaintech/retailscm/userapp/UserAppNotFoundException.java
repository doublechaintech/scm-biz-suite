package com.doublechaintech.retailscm.userapp;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class UserAppNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public UserAppNotFoundException(String string) {
    super(string);
  }
}
