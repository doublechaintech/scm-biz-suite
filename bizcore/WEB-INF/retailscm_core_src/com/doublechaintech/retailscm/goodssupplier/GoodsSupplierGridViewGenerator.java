package com.doublechaintech.retailscm.goodssupplier;

import com.doublechaintech.retailscm.AccessKey;

import com.doublechaintech.retailscm.BaseGridViewGenerator;

public class GoodsSupplierGridViewGenerator extends BaseGridViewGenerator {

  private static final long serialVersionUID = 1L;

  protected void throwExceptionIfListNotFount(String listName) {
    String message = String.format("List '%s' is not found for GoodsSupplier", listName);
    throw new IllegalArgumentException(message);
  }

  protected String[] getHeaderKeys(String listName) {

    if (GoodsSupplier.SUPPLIER_PRODUCT_LIST.equals(listName)) {
      return new String[] {
        "id", "product_name", "product_description", "product_unit", "supplier", "version"
      };
    }
    if (GoodsSupplier.SUPPLY_ORDER_LIST.equals(listName)) {
      return new String[] {
        "id", "buyer", "seller", "title", "contract", "total_amount", "last_update_time", "version"
      };
    }
    if (GoodsSupplier.ACCOUNT_SET_LIST.equals(listName)) {
      return new String[] {
        "id",
        "name",
        "year_set",
        "effective_date",
        "accounting_system",
        "domestic_currency_code",
        "domestic_currency_name",
        "opening_bank",
        "account_number",
        "country_center",
        "retail_store",
        "goods_supplier",
        "last_update_time",
        "version"
      };
    }

    throwExceptionIfListNotFount(listName);
    return new String[] {}; // place holder, code will never go here!!!
  }

  protected String getObjectKey(String listName) {
    if (GoodsSupplier.SUPPLIER_PRODUCT_LIST.equals(listName)) {
      return "supplier_product";
    }
    if (GoodsSupplier.SUPPLY_ORDER_LIST.equals(listName)) {
      return "supply_order";
    }
    if (GoodsSupplier.ACCOUNT_SET_LIST.equals(listName)) {
      return "account_set";
    }

    throwExceptionIfListNotFount(listName);
    return ""; // place holder, code will never go here!!!
  }
}
