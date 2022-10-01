package com.doublechaintech.retailscm.memberwishlistproduct;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class MemberWishlistProductNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public MemberWishlistProductNotFoundException(String string) {
    super(string);
  }
}
