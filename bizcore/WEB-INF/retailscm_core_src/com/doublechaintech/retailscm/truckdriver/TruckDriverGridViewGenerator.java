package com.doublechaintech.retailscm.truckdriver;

import com.doublechaintech.retailscm.AccessKey;

import com.doublechaintech.retailscm.BaseGridViewGenerator;

public class TruckDriverGridViewGenerator extends BaseGridViewGenerator {

  private static final long serialVersionUID = 1L;

  protected void throwExceptionIfListNotFount(String listName) {
    String message = String.format("List '%s' is not found for TruckDriver", listName);
    throw new IllegalArgumentException(message);
  }

  protected String[] getHeaderKeys(String listName) {

    if (TruckDriver.TRANSPORT_TASK_LIST.equals(listName)) {
      return new String[] {
        "id",
        "name",
        "start",
        "begin_time",
        "end",
        "driver",
        "truck",
        "belongs_to",
        "latitude",
        "longitude",
        "version"
      };
    }

    throwExceptionIfListNotFount(listName);
    return new String[] {}; // place holder, code will never go here!!!
  }

  protected String getObjectKey(String listName) {
    if (TruckDriver.TRANSPORT_TASK_LIST.equals(listName)) {
      return "transport_task";
    }

    throwExceptionIfListNotFount(listName);
    return ""; // place holder, code will never go here!!!
  }
}
