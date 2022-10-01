package com.doublechaintech.retailscm.retailstorecityservicecenter;

import com.doublechaintech.retailscm.AccessKey;

import com.doublechaintech.retailscm.BaseGridViewGenerator;

public class RetailStoreCityServiceCenterGridViewGenerator extends BaseGridViewGenerator {

  private static final long serialVersionUID = 1L;

  protected void throwExceptionIfListNotFount(String listName) {
    String message =
        String.format("List '%s' is not found for RetailStoreCityServiceCenter", listName);
    throw new IllegalArgumentException(message);
  }

  protected String[] getHeaderKeys(String listName) {

    if (RetailStoreCityServiceCenter.CITY_PARTNER_LIST.equals(listName)) {
      return new String[] {
        "id", "name", "mobile", "city_service_center", "description", "last_update_time", "version"
      };
    }
    if (RetailStoreCityServiceCenter.POTENTIAL_CUSTOMER_LIST.equals(listName)) {
      return new String[] {
        "id",
        "name",
        "mobile",
        "city_service_center",
        "city_partner",
        "description",
        "last_update_time",
        "version"
      };
    }
    if (RetailStoreCityServiceCenter.CITY_EVENT_LIST.equals(listName)) {
      return new String[] {
        "id", "name", "mobile", "city_service_center", "description", "last_update_time", "version"
      };
    }
    if (RetailStoreCityServiceCenter.RETAIL_STORE_LIST.equals(listName)) {
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
    if (RetailStoreCityServiceCenter.CITY_PARTNER_LIST.equals(listName)) {
      return "city_partner";
    }
    if (RetailStoreCityServiceCenter.POTENTIAL_CUSTOMER_LIST.equals(listName)) {
      return "potential_customer";
    }
    if (RetailStoreCityServiceCenter.CITY_EVENT_LIST.equals(listName)) {
      return "city_event";
    }
    if (RetailStoreCityServiceCenter.RETAIL_STORE_LIST.equals(listName)) {
      return "retail_store";
    }

    throwExceptionIfListNotFount(listName);
    return ""; // place holder, code will never go here!!!
  }
}
