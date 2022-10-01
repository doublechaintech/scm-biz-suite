package com.doublechaintech.retailscm.retailstoreorder;

import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class RetailStoreOrderTable {

  public static AccessKey withId(Object value) {
    AccessKey accessKey = new AccessKey();
    accessKey.setColumnName(COLUMN_ID);
    accessKey.setValue(value);
    return accessKey;
  }
  // Add extra identifiers

  // only this package can use this, so the scope is default, not public, not private either nor
  // protected
  public static final String TABLE_NAME = "retail_store_order_data";
  static final String COLUMN_ID = "id";
  static final String COLUMN_BUYER = "buyer";
  static final String COLUMN_SELLER = "seller";
  static final String COLUMN_TITLE = "title";
  static final String COLUMN_TOTAL_AMOUNT = "total_amount";
  static final String COLUMN_CONTRACT = "contract";
  static final String COLUMN_LAST_UPDATE_TIME = "last_update_time";
  static final String COLUMN_VERSION = "version";

  public static final String[] ALL_CLOUMNS = {
    COLUMN_ID,
    COLUMN_BUYER,
    COLUMN_SELLER,
    COLUMN_TITLE,
    COLUMN_TOTAL_AMOUNT,
    COLUMN_CONTRACT,
    COLUMN_LAST_UPDATE_TIME,
    COLUMN_VERSION
  };
  public static final String[] NORMAL_CLOUMNS = {
    COLUMN_BUYER,
    COLUMN_SELLER,
    COLUMN_TITLE,
    COLUMN_TOTAL_AMOUNT,
    COLUMN_CONTRACT,
    COLUMN_LAST_UPDATE_TIME
  };

  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result)
      throws Exception {
    RetailscmBaseUtils.ensureTable(
        userContext,
        result,
        "retail_store_order_data",
        new String[][] {
          new String[] {"id", "varchar(48)", " not null", "ID", "", ""},
          new String[] {"buyer", "varchar(48)", "", "买方", "retail_store_data", "id"},
          new String[] {
            "seller", "varchar(48)", "", "卖方", "retail_store_country_center_data", "id"
          },
          new String[] {"title", "varchar(56)", "", "头衔", "", ""},
          new String[] {"total_amount", "numeric(14,2)", "", "总金额", "", ""},
          new String[] {"contract", "varchar(1024)", "", "合同", "", ""},
          new String[] {"last_update_time", "datetime", "", "更新于", "", ""},
          new String[] {"version", "int", "", "版本", "", ""}
        },
        "生超的订单",
        new String[] {
          "create unique index idx4id_ver_of_retail_store_order on retail_store_order_data (id, version);",
          "create  index idx4total_amount_of_retail_store_order on retail_store_order_data (total_amount);",
          "create  index idx4last_update_time_of_retail_store_order on retail_store_order_data (last_update_time);",
          "create  index idx4version_of_retail_store_order on retail_store_order_data (version);"
        },
        new String[] {
          "alter table retail_store_order_data add constraint pk4id_of_retail_store_order_data primary key (id);",
          "alter table retail_store_order_data add constraint fk4buyer_of_retail_store_order_data foreign key (buyer) references retail_store_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
          "alter table retail_store_order_data add constraint fk4seller_of_retail_store_order_data foreign key (seller) references retail_store_country_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
          ""
        });
  }
}
