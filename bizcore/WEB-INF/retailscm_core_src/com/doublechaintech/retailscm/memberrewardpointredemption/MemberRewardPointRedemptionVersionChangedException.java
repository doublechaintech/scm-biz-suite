package com.doublechaintech.retailscm.memberrewardpointredemption;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class MemberRewardPointRedemptionVersionChangedException
    extends MemberRewardPointRedemptionManagerException {
  private static final long serialVersionUID = 1L;

  public MemberRewardPointRedemptionVersionChangedException(String string) {
    super(string);
  }
}
