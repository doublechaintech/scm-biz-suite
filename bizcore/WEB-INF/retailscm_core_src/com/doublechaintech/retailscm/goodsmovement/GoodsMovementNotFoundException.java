package com.doublechaintech.retailscm.goodsmovement;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class GoodsMovementNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public GoodsMovementNotFoundException(String string) {
    super(string);
  }
}
