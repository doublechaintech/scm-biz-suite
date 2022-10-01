package com.doublechaintech.retailscm.page;

import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class PageTable {

  public static AccessKey withId(Object value) {
    AccessKey accessKey = new AccessKey();
    accessKey.setColumnName(COLUMN_ID);
    accessKey.setValue(value);
    return accessKey;
  }
  // Add extra identifiers

  // only this package can use this, so the scope is default, not public, not private either nor
  // protected
  public static final String TABLE_NAME = "page_data";
  static final String COLUMN_ID = "id";
  static final String COLUMN_PAGE_TITLE = "page_title";
  static final String COLUMN_LINK_TO_URL = "link_to_url";
  static final String COLUMN_PAGE_TYPE = "page_type";
  static final String COLUMN_DISPLAY_ORDER = "display_order";
  static final String COLUMN_MOBILE_APP = "mobile_app";
  static final String COLUMN_VERSION = "version";

  public static final String[] ALL_CLOUMNS = {
    COLUMN_ID,
    COLUMN_PAGE_TITLE,
    COLUMN_LINK_TO_URL,
    COLUMN_PAGE_TYPE,
    COLUMN_DISPLAY_ORDER,
    COLUMN_MOBILE_APP,
    COLUMN_VERSION
  };
  public static final String[] NORMAL_CLOUMNS = {
    COLUMN_PAGE_TITLE, COLUMN_LINK_TO_URL, COLUMN_PAGE_TYPE, COLUMN_DISPLAY_ORDER, COLUMN_MOBILE_APP
  };

  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result)
      throws Exception {
    RetailscmBaseUtils.ensureTable(
        userContext,
        result,
        "page_data",
        new String[][] {
          new String[] {"id", "varchar(48)", " not null", "ID", "", ""},
          new String[] {"page_title", "varchar(10)", "", "页面标题", "", ""},
          new String[] {"link_to_url", "varchar(512)", "", "链接网址", "", ""},
          new String[] {"page_type", "varchar(48)", "", "页面类型", "page_type_data", "id"},
          new String[] {"display_order", "int", "", "顺序", "", ""},
          new String[] {"mobile_app", "varchar(48)", "", "手机应用程序", "mobile_app_data", "id"},
          new String[] {"version", "int", "", "版本", "", ""}
        },
        "页面",
        new String[] {
          "create unique index idx4id_ver_of_page on page_data (id, version);",
          "create  index idx4display_order_of_page on page_data (display_order);",
          "create  index idx4version_of_page on page_data (version);"
        },
        new String[] {
          "alter table page_data add constraint pk4id_of_page_data primary key (id);",
          "alter table page_data add constraint fk4page_type_of_page_data foreign key (page_type) references page_type_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
          "alter table page_data add constraint fk4mobile_app_of_page_data foreign key (mobile_app) references mobile_app_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
          ""
        });
  }
}
