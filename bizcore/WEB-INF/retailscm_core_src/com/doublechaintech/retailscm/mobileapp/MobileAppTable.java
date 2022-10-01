package com.doublechaintech.retailscm.mobileapp;

import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class MobileAppTable {

  public static AccessKey withId(Object value) {
    AccessKey accessKey = new AccessKey();
    accessKey.setColumnName(COLUMN_ID);
    accessKey.setValue(value);
    return accessKey;
  }
  // Add extra identifiers

  // only this package can use this, so the scope is default, not public, not private either nor
  // protected
  public static final String TABLE_NAME = "mobile_app_data";
  static final String COLUMN_ID = "id";
  static final String COLUMN_NAME = "name";
  static final String COLUMN_VERSION = "version";

  public static final String[] ALL_CLOUMNS = {COLUMN_ID, COLUMN_NAME, COLUMN_VERSION};
  public static final String[] NORMAL_CLOUMNS = {COLUMN_NAME};

  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result)
      throws Exception {
    RetailscmBaseUtils.ensureTable(
        userContext,
        result,
        "mobile_app_data",
        new String[][] {
          new String[] {"id", "varchar(48)", " not null", "ID", "", ""},
          new String[] {"name", "varchar(20)", "", "名称", "", ""},
          new String[] {"version", "int", "", "版本", "", ""}
        },
        "手机应用程序",
        new String[] {
          "create unique index idx4id_ver_of_mobile_app on mobile_app_data (id, version);",
          "create  index idx4version_of_mobile_app on mobile_app_data (version);"
        },
        new String[] {
          "alter table mobile_app_data add constraint pk4id_of_mobile_app_data primary key (id);",
          ""
        });
  }
}
