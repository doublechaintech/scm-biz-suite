package com.doublechaintech.retailscm.supplyorderlineitem;

import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class SupplyOrderLineItemTable {

  public static AccessKey withId(Object value) {
    AccessKey accessKey = new AccessKey();
    accessKey.setColumnName(COLUMN_ID);
    accessKey.setValue(value);
    return accessKey;
  }
  // Add extra identifiers

  // only this package can use this, so the scope is default, not public, not private either nor
  // protected
  public static final String TABLE_NAME = "supply_order_line_item_data";
  static final String COLUMN_ID = "id";
  static final String COLUMN_BIZ_ORDER = "biz_order";
  static final String COLUMN_SKU_ID = "sku_id";
  static final String COLUMN_SKU_NAME = "sku_name";
  static final String COLUMN_AMOUNT = "amount";
  static final String COLUMN_QUANTITY = "quantity";
  static final String COLUMN_UNIT_OF_MEASUREMENT = "unit_of_measurement";
  static final String COLUMN_VERSION = "version";

  public static final String[] ALL_CLOUMNS = {
    COLUMN_ID,
    COLUMN_BIZ_ORDER,
    COLUMN_SKU_ID,
    COLUMN_SKU_NAME,
    COLUMN_AMOUNT,
    COLUMN_QUANTITY,
    COLUMN_UNIT_OF_MEASUREMENT,
    COLUMN_VERSION
  };
  public static final String[] NORMAL_CLOUMNS = {
    COLUMN_BIZ_ORDER,
    COLUMN_SKU_ID,
    COLUMN_SKU_NAME,
    COLUMN_AMOUNT,
    COLUMN_QUANTITY,
    COLUMN_UNIT_OF_MEASUREMENT
  };

  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result)
      throws Exception {
    RetailscmBaseUtils.ensureTable(
        userContext,
        result,
        "supply_order_line_item_data",
        new String[][] {
          new String[] {"id", "varchar(48)", " not null", "ID", "", ""},
          new String[] {"biz_order", "varchar(48)", "", "订单", "supply_order_data", "id"},
          new String[] {"sku_id", "varchar(12)", "", "产品ID", "", ""},
          new String[] {"sku_name", "varchar(16)", "", "产品名称", "", ""},
          new String[] {"amount", "numeric(5,2)", "", "金额", "", ""},
          new String[] {"quantity", "int", "", "数量", "", ""},
          new String[] {"unit_of_measurement", "varchar(8)", "", "测量单位", "", ""},
          new String[] {"version", "int", "", "版本", "", ""}
        },
        "供应订单行项目",
        new String[] {
          "create unique index idx4id_ver_of_supply_order_line_item on supply_order_line_item_data (id, version);",
          "create  index idx4sku_id_of_supply_order_line_item on supply_order_line_item_data (sku_id);",
          "create  index idx4amount_of_supply_order_line_item on supply_order_line_item_data (amount);",
          "create  index idx4quantity_of_supply_order_line_item on supply_order_line_item_data (quantity);",
          "create  index idx4version_of_supply_order_line_item on supply_order_line_item_data (version);"
        },
        new String[] {
          "alter table supply_order_line_item_data add constraint pk4id_of_supply_order_line_item_data primary key (id);",
          "alter table supply_order_line_item_data add constraint fk4biz_order_of_supply_order_line_item_data foreign key (biz_order) references supply_order_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
          ""
        });
  }
}
