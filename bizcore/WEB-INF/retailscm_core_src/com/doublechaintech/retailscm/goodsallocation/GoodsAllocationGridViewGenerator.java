package com.doublechaintech.retailscm.goodsallocation;

import com.doublechaintech.retailscm.AccessKey;

import com.doublechaintech.retailscm.BaseGridViewGenerator;

public class GoodsAllocationGridViewGenerator extends BaseGridViewGenerator {

  private static final long serialVersionUID = 1L;

  protected void throwExceptionIfListNotFount(String listName) {
    String message = String.format("List '%s' is not found for GoodsAllocation", listName);
    throw new IllegalArgumentException(message);
  }

  protected String[] getHeaderKeys(String listName) {

    if (GoodsAllocation.GOODS_LIST.equals(listName)) {
      return new String[] {
        "id",
        "name",
        "rfid",
        "uom",
        "max_package",
        "expire_time",
        "sku",
        "receiving_space",
        "goods_allocation",
        "smart_pallet",
        "shipping_space",
        "transport_task",
        "retail_store",
        "biz_order",
        "retail_store_order",
        "version"
      };
    }

    throwExceptionIfListNotFount(listName);
    return new String[] {}; // place holder, code will never go here!!!
  }

  protected String getObjectKey(String listName) {
    if (GoodsAllocation.GOODS_LIST.equals(listName)) {
      return "goods";
    }

    throwExceptionIfListNotFount(listName);
    return ""; // place holder, code will never go here!!!
  }
}
