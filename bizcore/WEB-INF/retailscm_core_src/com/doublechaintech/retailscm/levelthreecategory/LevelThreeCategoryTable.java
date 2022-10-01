package com.doublechaintech.retailscm.levelthreecategory;

import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class LevelThreeCategoryTable {

  public static AccessKey withId(Object value) {
    AccessKey accessKey = new AccessKey();
    accessKey.setColumnName(COLUMN_ID);
    accessKey.setValue(value);
    return accessKey;
  }
  // Add extra identifiers

  // only this package can use this, so the scope is default, not public, not private either nor
  // protected
  public static final String TABLE_NAME = "level_three_category_data";
  static final String COLUMN_ID = "id";
  static final String COLUMN_PARENT_CATEGORY = "parent_category";
  static final String COLUMN_NAME = "name";
  static final String COLUMN_VERSION = "version";

  public static final String[] ALL_CLOUMNS = {
    COLUMN_ID, COLUMN_PARENT_CATEGORY, COLUMN_NAME, COLUMN_VERSION
  };
  public static final String[] NORMAL_CLOUMNS = {COLUMN_PARENT_CATEGORY, COLUMN_NAME};

  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result)
      throws Exception {
    RetailscmBaseUtils.ensureTable(
        userContext,
        result,
        "level_three_category_data",
        new String[][] {
          new String[] {"id", "varchar(48)", " not null", "ID", "", ""},
          new String[] {
            "parent_category", "varchar(48)", "", "父类", "level_two_category_data", "id"
          },
          new String[] {"name", "varchar(16)", "", "名称", "", ""},
          new String[] {"version", "int", "", "版本", "", ""}
        },
        "三级分类",
        new String[] {
          "create unique index idx4id_ver_of_level_three_category on level_three_category_data (id, version);",
          "create  index idx4version_of_level_three_category on level_three_category_data (version);"
        },
        new String[] {
          "alter table level_three_category_data add constraint pk4id_of_level_three_category_data primary key (id);",
          "alter table level_three_category_data add constraint fk4parent_category_of_level_three_category_data foreign key (parent_category) references level_two_category_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
          ""
        });
  }
}
