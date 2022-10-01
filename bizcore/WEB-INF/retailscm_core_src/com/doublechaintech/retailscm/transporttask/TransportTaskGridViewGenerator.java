package com.doublechaintech.retailscm.transporttask;

import com.doublechaintech.retailscm.AccessKey;

import com.doublechaintech.retailscm.BaseGridViewGenerator;

public class TransportTaskGridViewGenerator extends BaseGridViewGenerator {

  private static final long serialVersionUID = 1L;

  protected void throwExceptionIfListNotFount(String listName) {
    String message = String.format("List '%s' is not found for TransportTask", listName);
    throw new IllegalArgumentException(message);
  }

  protected String[] getHeaderKeys(String listName) {

    if (TransportTask.GOODS_LIST.equals(listName)) {
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
    if (TransportTask.TRANSPORT_TASK_TRACK_LIST.equals(listName)) {
      return new String[] {"id", "track_time", "latitude", "longitude", "movement", "version"};
    }

    throwExceptionIfListNotFount(listName);
    return new String[] {}; // place holder, code will never go here!!!
  }

  protected String getObjectKey(String listName) {
    if (TransportTask.GOODS_LIST.equals(listName)) {
      return "goods";
    }
    if (TransportTask.TRANSPORT_TASK_TRACK_LIST.equals(listName)) {
      return "transport_task_track";
    }

    throwExceptionIfListNotFount(listName);
    return ""; // place holder, code will never go here!!!
  }
}
