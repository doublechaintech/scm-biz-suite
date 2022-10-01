package com.doublechaintech.retailscm.quicklink;

import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class QuickLinkTable {

  public static AccessKey withId(Object value) {
    AccessKey accessKey = new AccessKey();
    accessKey.setColumnName(COLUMN_ID);
    accessKey.setValue(value);
    return accessKey;
  }
  // Add extra identifiers

  // only this package can use this, so the scope is default, not public, not private either nor
  // protected
  public static final String TABLE_NAME = "quick_link_data";
  static final String COLUMN_ID = "id";
  static final String COLUMN_NAME = "name";
  static final String COLUMN_ICON = "icon";
  static final String COLUMN_IMAGE_PATH = "image_path";
  static final String COLUMN_LINK_TARGET = "link_target";
  static final String COLUMN_CREATE_TIME = "create_time";
  static final String COLUMN_APP = "app";
  static final String COLUMN_VERSION = "version";

  public static final String[] ALL_CLOUMNS = {
    COLUMN_ID,
    COLUMN_NAME,
    COLUMN_ICON,
    COLUMN_IMAGE_PATH,
    COLUMN_LINK_TARGET,
    COLUMN_CREATE_TIME,
    COLUMN_APP,
    COLUMN_VERSION
  };
  public static final String[] NORMAL_CLOUMNS = {
    COLUMN_NAME, COLUMN_ICON, COLUMN_IMAGE_PATH, COLUMN_LINK_TARGET, COLUMN_CREATE_TIME, COLUMN_APP
  };

  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result)
      throws Exception {
    RetailscmBaseUtils.ensureTable(
        userContext,
        result,
        "quick_link_data",
        new String[][] {
          new String[] {"id", "varchar(48)", " not null", "ID", "", ""},
          new String[] {"name", "varchar(200)", "", "名称", "", ""},
          new String[] {"icon", "varchar(200)", "", "图标", "", ""},
          new String[] {
            "image_path",
            "varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci",
            "",
            "图片路径",
            "",
            ""
          },
          new String[] {"link_target", "varchar(200)", "", "链接的目标", "", ""},
          new String[] {"create_time", "datetime", "", "创建于", "", ""},
          new String[] {"app", "varchar(48)", "", "应用程序", "user_app_data", "id"},
          new String[] {"version", "int", "", "版本", "", ""}
        },
        "快速链接",
        new String[] {
          "create unique index idx4id_ver_of_quick_link on quick_link_data (id, version);",
          "create  index idx4create_time_of_quick_link on quick_link_data (create_time);",
          "create  index idx4version_of_quick_link on quick_link_data (version);"
        },
        new String[] {
          "alter table quick_link_data add constraint pk4id_of_quick_link_data primary key (id);",
          "alter table quick_link_data add constraint fk4app_of_quick_link_data foreign key (app) references user_app_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
          ""
        });
  }
}
