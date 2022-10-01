package com.doublechaintech.retailscm.cityevent;

import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class CityEventTable {

  public static AccessKey withId(Object value) {
    AccessKey accessKey = new AccessKey();
    accessKey.setColumnName(COLUMN_ID);
    accessKey.setValue(value);
    return accessKey;
  }
  // Add extra identifiers

  // only this package can use this, so the scope is default, not public, not private either nor
  // protected
  public static final String TABLE_NAME = "city_event_data";
  static final String COLUMN_ID = "id";
  static final String COLUMN_NAME = "name";
  static final String COLUMN_MOBILE = "mobile";
  static final String COLUMN_CITY_SERVICE_CENTER = "city_service_center";
  static final String COLUMN_DESCRIPTION = "description";
  static final String COLUMN_LAST_UPDATE_TIME = "last_update_time";
  static final String COLUMN_VERSION = "version";

  public static final String[] ALL_CLOUMNS = {
    COLUMN_ID,
    COLUMN_NAME,
    COLUMN_MOBILE,
    COLUMN_CITY_SERVICE_CENTER,
    COLUMN_DESCRIPTION,
    COLUMN_LAST_UPDATE_TIME,
    COLUMN_VERSION
  };
  public static final String[] NORMAL_CLOUMNS = {
    COLUMN_NAME,
    COLUMN_MOBILE,
    COLUMN_CITY_SERVICE_CENTER,
    COLUMN_DESCRIPTION,
    COLUMN_LAST_UPDATE_TIME
  };

  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result)
      throws Exception {
    RetailscmBaseUtils.ensureTable(
        userContext,
        result,
        "city_event_data",
        new String[][] {
          new String[] {"id", "varchar(48)", " not null", "ID", "", ""},
          new String[] {"name", "varchar(28)", "", "名称", "", ""},
          new String[] {"mobile", "varchar(44)", "", "手机", "", ""},
          new String[] {
            "city_service_center",
            "varchar(48)",
            "",
            "城市服务中心",
            "retail_store_city_service_center_data",
            "id"
          },
          new String[] {"description", "varchar(48)", "", "描述", "", ""},
          new String[] {"last_update_time", "datetime", "", "更新于", "", ""},
          new String[] {"version", "int", "", "版本", "", ""}
        },
        "城市活动",
        new String[] {
          "create unique index idx4id_ver_of_city_event on city_event_data (id, version);",
          "create  index idx4mobile_of_city_event on city_event_data (mobile);",
          "create  index idx4last_update_time_of_city_event on city_event_data (last_update_time);",
          "create  index idx4version_of_city_event on city_event_data (version);"
        },
        new String[] {
          "alter table city_event_data add constraint pk4id_of_city_event_data primary key (id);",
          "alter table city_event_data add constraint fk4city_service_center_of_city_event_data foreign key (city_service_center) references retail_store_city_service_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
          ""
        });
  }
}
