package com.doublechaintech.retailscm.damagespace;

import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class DamageSpaceTable {

  public static AccessKey withId(Object value) {
    AccessKey accessKey = new AccessKey();
    accessKey.setColumnName(COLUMN_ID);
    accessKey.setValue(value);
    return accessKey;
  }
  // Add extra identifiers

  // only this package can use this, so the scope is default, not public, not private either nor
  // protected
  public static final String TABLE_NAME = "damage_space_data";
  static final String COLUMN_ID = "id";
  static final String COLUMN_LOCATION = "location";
  static final String COLUMN_CONTACT_NUMBER = "contact_number";
  static final String COLUMN_TOTAL_AREA = "total_area";
  static final String COLUMN_LATITUDE = "latitude";
  static final String COLUMN_LONGITUDE = "longitude";
  static final String COLUMN_WAREHOUSE = "warehouse";
  static final String COLUMN_LAST_UPDATE_TIME = "last_update_time";
  static final String COLUMN_VERSION = "version";

  public static final String[] ALL_CLOUMNS = {
    COLUMN_ID,
    COLUMN_LOCATION,
    COLUMN_CONTACT_NUMBER,
    COLUMN_TOTAL_AREA,
    COLUMN_LATITUDE,
    COLUMN_LONGITUDE,
    COLUMN_WAREHOUSE,
    COLUMN_LAST_UPDATE_TIME,
    COLUMN_VERSION
  };
  public static final String[] NORMAL_CLOUMNS = {
    COLUMN_LOCATION,
    COLUMN_CONTACT_NUMBER,
    COLUMN_TOTAL_AREA,
    COLUMN_LATITUDE,
    COLUMN_LONGITUDE,
    COLUMN_WAREHOUSE,
    COLUMN_LAST_UPDATE_TIME
  };

  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result)
      throws Exception {
    RetailscmBaseUtils.ensureTable(
        userContext,
        result,
        "damage_space_data",
        new String[][] {
          new String[] {"id", "varchar(48)", " not null", "ID", "", ""},
          new String[] {"location", "varchar(80)", "", "位置", "", ""},
          new String[] {"contact_number", "varchar(48)", "", "联系电话", "", ""},
          new String[] {"total_area", "varchar(28)", "", "总面积", "", ""},
          new String[] {"latitude", "numeric(9,6)", "", "纬度", "", ""},
          new String[] {"longitude", "numeric(10,6)", "", "经度", "", ""},
          new String[] {"warehouse", "varchar(48)", "", "仓库", "warehouse_data", "id"},
          new String[] {"last_update_time", "datetime", "", "更新于", "", ""},
          new String[] {"version", "int", "", "版本", "", ""}
        },
        "残次货物存放区",
        new String[] {
          "create unique index idx4id_ver_of_damage_space on damage_space_data (id, version);",
          "create  index idx4latitude_of_damage_space on damage_space_data (latitude);",
          "create  index idx4longitude_of_damage_space on damage_space_data (longitude);",
          "create  index idx4last_update_time_of_damage_space on damage_space_data (last_update_time);",
          "create  index idx4version_of_damage_space on damage_space_data (version);"
        },
        new String[] {
          "alter table damage_space_data add constraint pk4id_of_damage_space_data primary key (id);",
          "alter table damage_space_data add constraint fk4warehouse_of_damage_space_data foreign key (warehouse) references warehouse_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
          ""
        });
  }
}
