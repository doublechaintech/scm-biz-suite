package com.doublechaintech.retailscm.userallowlist;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class UserAllowListNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public UserAllowListNotFoundException(String string) {
    super(string);
  }
}
