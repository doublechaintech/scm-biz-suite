package com.doublechaintech.retailscm.warehouse;

import com.doublechaintech.retailscm.AccessKey;

import com.doublechaintech.retailscm.BaseGridViewGenerator;

public class WarehouseGridViewGenerator extends BaseGridViewGenerator {

  private static final long serialVersionUID = 1L;

  protected void throwExceptionIfListNotFount(String listName) {
    String message = String.format("List '%s' is not found for Warehouse", listName);
    throw new IllegalArgumentException(message);
  }

  protected String[] getHeaderKeys(String listName) {

    if (Warehouse.STORAGE_SPACE_LIST.equals(listName)) {
      return new String[] {
        "id",
        "location",
        "contact_number",
        "total_area",
        "warehouse",
        "latitude",
        "longitude",
        "last_update_time",
        "version"
      };
    }
    if (Warehouse.SMART_PALLET_LIST.equals(listName)) {
      return new String[] {
        "id",
        "location",
        "contact_number",
        "total_area",
        "latitude",
        "longitude",
        "warehouse",
        "last_update_time",
        "version"
      };
    }
    if (Warehouse.SUPPLIER_SPACE_LIST.equals(listName)) {
      return new String[] {
        "id",
        "location",
        "contact_number",
        "total_area",
        "warehouse",
        "latitude",
        "longitude",
        "last_update_time",
        "version"
      };
    }
    if (Warehouse.RECEIVING_SPACE_LIST.equals(listName)) {
      return new String[] {
        "id",
        "location",
        "contact_number",
        "description",
        "total_area",
        "warehouse",
        "latitude",
        "longitude",
        "last_update_time",
        "version"
      };
    }
    if (Warehouse.SHIPPING_SPACE_LIST.equals(listName)) {
      return new String[] {
        "id",
        "location",
        "contact_number",
        "total_area",
        "warehouse",
        "latitude",
        "longitude",
        "description",
        "last_update_time",
        "version"
      };
    }
    if (Warehouse.DAMAGE_SPACE_LIST.equals(listName)) {
      return new String[] {
        "id",
        "location",
        "contact_number",
        "total_area",
        "latitude",
        "longitude",
        "warehouse",
        "last_update_time",
        "version"
      };
    }
    if (Warehouse.WAREHOUSE_ASSET_LIST.equals(listName)) {
      return new String[] {"id", "name", "position", "owner", "last_update_time", "version"};
    }

    throwExceptionIfListNotFount(listName);
    return new String[] {}; // place holder, code will never go here!!!
  }

  protected String getObjectKey(String listName) {
    if (Warehouse.STORAGE_SPACE_LIST.equals(listName)) {
      return "storage_space";
    }
    if (Warehouse.SMART_PALLET_LIST.equals(listName)) {
      return "smart_pallet";
    }
    if (Warehouse.SUPPLIER_SPACE_LIST.equals(listName)) {
      return "supplier_space";
    }
    if (Warehouse.RECEIVING_SPACE_LIST.equals(listName)) {
      return "receiving_space";
    }
    if (Warehouse.SHIPPING_SPACE_LIST.equals(listName)) {
      return "shipping_space";
    }
    if (Warehouse.DAMAGE_SPACE_LIST.equals(listName)) {
      return "damage_space";
    }
    if (Warehouse.WAREHOUSE_ASSET_LIST.equals(listName)) {
      return "warehouse_asset";
    }

    throwExceptionIfListNotFount(listName);
    return ""; // place holder, code will never go here!!!
  }
}
