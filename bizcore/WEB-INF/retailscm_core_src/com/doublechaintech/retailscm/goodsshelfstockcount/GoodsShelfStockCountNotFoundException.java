package com.doublechaintech.retailscm.goodsshelfstockcount;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class GoodsShelfStockCountNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public GoodsShelfStockCountNotFoundException(String string) {
    super(string);
  }
}
