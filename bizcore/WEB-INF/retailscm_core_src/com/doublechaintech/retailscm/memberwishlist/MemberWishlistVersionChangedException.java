package com.doublechaintech.retailscm.memberwishlist;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class MemberWishlistVersionChangedException extends MemberWishlistManagerException {
  private static final long serialVersionUID = 1L;

  public MemberWishlistVersionChangedException(String string) {
    super(string);
  }
}
