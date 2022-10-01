package com.doublechaintech.retailscm.goods;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class GoodsVersionChangedException extends GoodsManagerException {
  private static final long serialVersionUID = 1L;

  public GoodsVersionChangedException(String string) {
    super(string);
  }
}
