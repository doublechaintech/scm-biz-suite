package com.doublechaintech.retailscm.section;

import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class SectionTable {

  public static AccessKey withId(Object value) {
    AccessKey accessKey = new AccessKey();
    accessKey.setColumnName(COLUMN_ID);
    accessKey.setValue(value);
    return accessKey;
  }
  // Add extra identifiers

  // only this package can use this, so the scope is default, not public, not private either nor
  // protected
  public static final String TABLE_NAME = "section_data";
  static final String COLUMN_ID = "id";
  static final String COLUMN_TITLE = "title";
  static final String COLUMN_BRIEF = "brief";
  static final String COLUMN_ICON = "icon";
  static final String COLUMN_DISPLAY_ORDER = "display_order";
  static final String COLUMN_VIEW_GROUP = "view_group";
  static final String COLUMN_LINK_TO_URL = "link_to_url";
  static final String COLUMN_PAGE = "page";
  static final String COLUMN_VERSION = "version";

  public static final String[] ALL_CLOUMNS = {
    COLUMN_ID,
    COLUMN_TITLE,
    COLUMN_BRIEF,
    COLUMN_ICON,
    COLUMN_DISPLAY_ORDER,
    COLUMN_VIEW_GROUP,
    COLUMN_LINK_TO_URL,
    COLUMN_PAGE,
    COLUMN_VERSION
  };
  public static final String[] NORMAL_CLOUMNS = {
    COLUMN_TITLE,
    COLUMN_BRIEF,
    COLUMN_ICON,
    COLUMN_DISPLAY_ORDER,
    COLUMN_VIEW_GROUP,
    COLUMN_LINK_TO_URL,
    COLUMN_PAGE
  };

  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result)
      throws Exception {
    RetailscmBaseUtils.ensureTable(
        userContext,
        result,
        "section_data",
        new String[][] {
          new String[] {"id", "varchar(48)", " not null", "ID", "", ""},
          new String[] {"title", "varchar(40)", "", "头衔", "", ""},
          new String[] {"brief", "varchar(200)", "", "短暂的", "", ""},
          new String[] {
            "icon", "varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci", "", "图标", "", ""
          },
          new String[] {"display_order", "int", "", "顺序", "", ""},
          new String[] {"view_group", "varchar(40)", "", "视图组", "", ""},
          new String[] {"link_to_url", "varchar(512)", "", "链接网址", "", ""},
          new String[] {"page", "varchar(48)", "", "页面", "page_data", "id"},
          new String[] {"version", "int", "", "版本", "", ""}
        },
        "板块",
        new String[] {
          "create unique index idx4id_ver_of_section on section_data (id, version);",
          "create  index idx4display_order_of_section on section_data (display_order);",
          "create  index idx4version_of_section on section_data (version);"
        },
        new String[] {
          "alter table section_data add constraint pk4id_of_section_data primary key (id);",
          "alter table section_data add constraint fk4page_of_section_data foreign key (page) references page_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
          ""
        });
  }
}
