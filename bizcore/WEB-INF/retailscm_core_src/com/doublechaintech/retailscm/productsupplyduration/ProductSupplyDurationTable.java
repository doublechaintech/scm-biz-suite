package com.doublechaintech.retailscm.productsupplyduration;

import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class ProductSupplyDurationTable {

  public static AccessKey withId(Object value) {
    AccessKey accessKey = new AccessKey();
    accessKey.setColumnName(COLUMN_ID);
    accessKey.setValue(value);
    return accessKey;
  }
  // Add extra identifiers

  // only this package can use this, so the scope is default, not public, not private either nor
  // protected
  public static final String TABLE_NAME = "product_supply_duration_data";
  static final String COLUMN_ID = "id";
  static final String COLUMN_QUANTITY = "quantity";
  static final String COLUMN_DURATION = "duration";
  static final String COLUMN_PRICE = "price";
  static final String COLUMN_PRODUCT = "product";
  static final String COLUMN_VERSION = "version";

  public static final String[] ALL_CLOUMNS = {
    COLUMN_ID, COLUMN_QUANTITY, COLUMN_DURATION, COLUMN_PRICE, COLUMN_PRODUCT, COLUMN_VERSION
  };
  public static final String[] NORMAL_CLOUMNS = {
    COLUMN_QUANTITY, COLUMN_DURATION, COLUMN_PRICE, COLUMN_PRODUCT
  };

  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result)
      throws Exception {
    RetailscmBaseUtils.ensureTable(
        userContext,
        result,
        "product_supply_duration_data",
        new String[][] {
          new String[] {"id", "varchar(48)", " not null", "ID", "", ""},
          new String[] {"quantity", "int", "", "数量", "", ""},
          new String[] {"duration", "varchar(8)", "", "持续时间", "", ""},
          new String[] {"price", "numeric(8,2)", "", "价格", "", ""},
          new String[] {"product", "varchar(48)", "", "产品", "supplier_product_data", "id"},
          new String[] {"version", "int", "", "版本", "", ""}
        },
        "产品供应时间",
        new String[] {
          "create unique index idx4id_ver_of_product_supply_duration on product_supply_duration_data (id, version);",
          "create  index idx4quantity_of_product_supply_duration on product_supply_duration_data (quantity);",
          "create  index idx4price_of_product_supply_duration on product_supply_duration_data (price);",
          "create  index idx4version_of_product_supply_duration on product_supply_duration_data (version);"
        },
        new String[] {
          "alter table product_supply_duration_data add constraint pk4id_of_product_supply_duration_data primary key (id);",
          "alter table product_supply_duration_data add constraint fk4product_of_product_supply_duration_data foreign key (product) references supplier_product_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
          ""
        });
  }
}
