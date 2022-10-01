package com.doublechaintech.retailscm.goodsshelf;

import com.doublechaintech.retailscm.AccessKey;

import com.doublechaintech.retailscm.BaseGridViewGenerator;

public class GoodsShelfGridViewGenerator extends BaseGridViewGenerator {

  private static final long serialVersionUID = 1L;

  protected void throwExceptionIfListNotFount(String listName) {
    String message = String.format("List '%s' is not found for GoodsShelf", listName);
    throw new IllegalArgumentException(message);
  }

  protected String[] getHeaderKeys(String listName) {

    if (GoodsShelf.GOODS_SHELF_STOCK_COUNT_LIST.equals(listName)) {
      return new String[] {"id", "title", "count_time", "summary", "shelf", "version"};
    }
    if (GoodsShelf.GOODS_ALLOCATION_LIST.equals(listName)) {
      return new String[] {"id", "location", "latitude", "longitude", "goods_shelf", "version"};
    }

    throwExceptionIfListNotFount(listName);
    return new String[] {}; // place holder, code will never go here!!!
  }

  protected String getObjectKey(String listName) {
    if (GoodsShelf.GOODS_SHELF_STOCK_COUNT_LIST.equals(listName)) {
      return "goods_shelf_stock_count";
    }
    if (GoodsShelf.GOODS_ALLOCATION_LIST.equals(listName)) {
      return "goods_allocation";
    }

    throwExceptionIfListNotFount(listName);
    return ""; // place holder, code will never go here!!!
  }
}
