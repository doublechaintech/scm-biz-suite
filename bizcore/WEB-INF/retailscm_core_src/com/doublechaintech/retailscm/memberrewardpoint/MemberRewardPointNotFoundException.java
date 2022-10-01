package com.doublechaintech.retailscm.memberrewardpoint;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class MemberRewardPointNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public MemberRewardPointNotFoundException(String string) {
    super(string);
  }
}
