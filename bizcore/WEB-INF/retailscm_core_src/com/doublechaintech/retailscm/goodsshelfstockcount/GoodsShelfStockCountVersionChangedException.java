package com.doublechaintech.retailscm.goodsshelfstockcount;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class GoodsShelfStockCountVersionChangedException
    extends GoodsShelfStockCountManagerException {
  private static final long serialVersionUID = 1L;

  public GoodsShelfStockCountVersionChangedException(String string) {
    super(string);
  }
}
