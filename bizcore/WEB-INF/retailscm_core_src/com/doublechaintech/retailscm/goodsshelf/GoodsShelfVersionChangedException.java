package com.doublechaintech.retailscm.goodsshelf;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class GoodsShelfVersionChangedException extends GoodsShelfManagerException {
  private static final long serialVersionUID = 1L;

  public GoodsShelfVersionChangedException(String string) {
    super(string);
  }
}
