package com.doublechaintech.retailscm.warehouseasset;

import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class WarehouseAssetTable {

  public static AccessKey withId(Object value) {
    AccessKey accessKey = new AccessKey();
    accessKey.setColumnName(COLUMN_ID);
    accessKey.setValue(value);
    return accessKey;
  }
  // Add extra identifiers

  // only this package can use this, so the scope is default, not public, not private either nor
  // protected
  public static final String TABLE_NAME = "warehouse_asset_data";
  static final String COLUMN_ID = "id";
  static final String COLUMN_NAME = "name";
  static final String COLUMN_POSITION = "position";
  static final String COLUMN_OWNER = "owner";
  static final String COLUMN_LAST_UPDATE_TIME = "last_update_time";
  static final String COLUMN_VERSION = "version";

  public static final String[] ALL_CLOUMNS = {
    COLUMN_ID, COLUMN_NAME, COLUMN_POSITION, COLUMN_OWNER, COLUMN_LAST_UPDATE_TIME, COLUMN_VERSION
  };
  public static final String[] NORMAL_CLOUMNS = {
    COLUMN_NAME, COLUMN_POSITION, COLUMN_OWNER, COLUMN_LAST_UPDATE_TIME
  };

  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result)
      throws Exception {
    RetailscmBaseUtils.ensureTable(
        userContext,
        result,
        "warehouse_asset_data",
        new String[][] {
          new String[] {"id", "varchar(48)", " not null", "ID", "", ""},
          new String[] {"name", "varchar(20)", "", "名称", "", ""},
          new String[] {"position", "varchar(40)", "", "位置", "", ""},
          new String[] {"owner", "varchar(48)", "", "业主", "warehouse_data", "id"},
          new String[] {"last_update_time", "datetime", "", "更新于", "", ""},
          new String[] {"version", "int", "", "版本", "", ""}
        },
        "仓库资产",
        new String[] {
          "create unique index idx4id_ver_of_warehouse_asset on warehouse_asset_data (id, version);",
          "create  index idx4last_update_time_of_warehouse_asset on warehouse_asset_data (last_update_time);",
          "create  index idx4version_of_warehouse_asset on warehouse_asset_data (version);"
        },
        new String[] {
          "alter table warehouse_asset_data add constraint pk4id_of_warehouse_asset_data primary key (id);",
          "alter table warehouse_asset_data add constraint fk4owner_of_warehouse_asset_data foreign key (owner) references warehouse_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
          ""
        });
  }
}
