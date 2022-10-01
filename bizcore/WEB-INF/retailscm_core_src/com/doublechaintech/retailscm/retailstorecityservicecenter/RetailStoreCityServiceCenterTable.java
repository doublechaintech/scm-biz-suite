package com.doublechaintech.retailscm.retailstorecityservicecenter;

import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class RetailStoreCityServiceCenterTable {

  public static AccessKey withId(Object value) {
    AccessKey accessKey = new AccessKey();
    accessKey.setColumnName(COLUMN_ID);
    accessKey.setValue(value);
    return accessKey;
  }
  // Add extra identifiers

  // only this package can use this, so the scope is default, not public, not private either nor
  // protected
  public static final String TABLE_NAME = "retail_store_city_service_center_data";
  static final String COLUMN_ID = "id";
  static final String COLUMN_NAME = "name";
  static final String COLUMN_FOUNDED = "founded";
  static final String COLUMN_BELONGS_TO = "belongs_to";
  static final String COLUMN_LAST_UPDATE_TIME = "last_update_time";
  static final String COLUMN_VERSION = "version";

  public static final String[] ALL_CLOUMNS = {
    COLUMN_ID,
    COLUMN_NAME,
    COLUMN_FOUNDED,
    COLUMN_BELONGS_TO,
    COLUMN_LAST_UPDATE_TIME,
    COLUMN_VERSION
  };
  public static final String[] NORMAL_CLOUMNS = {
    COLUMN_NAME, COLUMN_FOUNDED, COLUMN_BELONGS_TO, COLUMN_LAST_UPDATE_TIME
  };

  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result)
      throws Exception {
    RetailscmBaseUtils.ensureTable(
        userContext,
        result,
        "retail_store_city_service_center_data",
        new String[][] {
          new String[] {"id", "varchar(48)", " not null", "ID", "", ""},
          new String[] {"name", "varchar(36)", "", "名称", "", ""},
          new String[] {"founded", "date", "", "成立", "", ""},
          new String[] {
            "belongs_to", "varchar(48)", "", "属于", "retail_store_province_center_data", "id"
          },
          new String[] {"last_update_time", "datetime", "", "更新于", "", ""},
          new String[] {"version", "int", "", "版本", "", ""}
        },
        "双链小超城市服务中心",
        new String[] {
          "create unique index idx4id_ver_of_retail_store_city_service_center on retail_store_city_service_center_data (id, version);",
          "create  index idx4founded_of_retail_store_city_service_center on retail_store_city_service_center_data (founded);",
          "create  index idx4last_update_time_of_retail_store_city_service_center on retail_store_city_service_center_data (last_update_time);",
          "create  index idx4version_of_retail_store_city_service_center on retail_store_city_service_center_data (version);"
        },
        new String[] {
          "alter table retail_store_city_service_center_data add constraint pk4id_of_retail_store_city_service_center_data primary key (id);",
          "alter table retail_store_city_service_center_data add constraint fk4belongs_to_of_retail_store_city_service_center_data foreign key (belongs_to) references retail_store_province_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
          ""
        });
  }
}
