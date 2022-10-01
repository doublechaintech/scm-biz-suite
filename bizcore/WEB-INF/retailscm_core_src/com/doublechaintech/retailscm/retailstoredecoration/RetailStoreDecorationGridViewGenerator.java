package com.doublechaintech.retailscm.retailstoredecoration;

import com.doublechaintech.retailscm.AccessKey;

import com.doublechaintech.retailscm.BaseGridViewGenerator;

public class RetailStoreDecorationGridViewGenerator extends BaseGridViewGenerator {

  private static final long serialVersionUID = 1L;

  protected void throwExceptionIfListNotFount(String listName) {
    String message = String.format("List '%s' is not found for RetailStoreDecoration", listName);
    throw new IllegalArgumentException(message);
  }

  protected String[] getHeaderKeys(String listName) {

    if (RetailStoreDecoration.RETAIL_STORE_LIST.equals(listName)) {
      return new String[] {
        "id",
        "name",
        "telephone",
        "owner",
        "retail_store_country_center",
        "city_service_center",
        "creation",
        "investment_invitation",
        "franchising",
        "decoration",
        "opening",
        "closing",
        "founded",
        "latitude",
        "longitude",
        "description",
        "last_update_time",
        "version"
      };
    }

    throwExceptionIfListNotFount(listName);
    return new String[] {}; // place holder, code will never go here!!!
  }

  protected String getObjectKey(String listName) {
    if (RetailStoreDecoration.RETAIL_STORE_LIST.equals(listName)) {
      return "retail_store";
    }

    throwExceptionIfListNotFount(listName);
    return ""; // place holder, code will never go here!!!
  }
}
