package com.doublechaintech.retailscm.retailstoremembercoupon;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class RetailStoreMemberCouponVersionChangedException
    extends RetailStoreMemberCouponManagerException {
  private static final long serialVersionUID = 1L;

  public RetailStoreMemberCouponVersionChangedException(String string) {
    super(string);
  }
}
