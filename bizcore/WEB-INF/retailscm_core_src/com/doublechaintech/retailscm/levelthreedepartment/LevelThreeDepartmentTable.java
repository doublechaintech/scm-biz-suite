package com.doublechaintech.retailscm.levelthreedepartment;

import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class LevelThreeDepartmentTable {

  public static AccessKey withId(Object value) {
    AccessKey accessKey = new AccessKey();
    accessKey.setColumnName(COLUMN_ID);
    accessKey.setValue(value);
    return accessKey;
  }
  // Add extra identifiers

  // only this package can use this, so the scope is default, not public, not private either nor
  // protected
  public static final String TABLE_NAME = "level_three_department_data";
  static final String COLUMN_ID = "id";
  static final String COLUMN_BELONGS_TO = "belongs_to";
  static final String COLUMN_NAME = "name";
  static final String COLUMN_DESCRIPTION = "description";
  static final String COLUMN_FOUNDED = "founded";
  static final String COLUMN_VERSION = "version";

  public static final String[] ALL_CLOUMNS = {
    COLUMN_ID, COLUMN_BELONGS_TO, COLUMN_NAME, COLUMN_DESCRIPTION, COLUMN_FOUNDED, COLUMN_VERSION
  };
  public static final String[] NORMAL_CLOUMNS = {
    COLUMN_BELONGS_TO, COLUMN_NAME, COLUMN_DESCRIPTION, COLUMN_FOUNDED
  };

  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result)
      throws Exception {
    RetailscmBaseUtils.ensureTable(
        userContext,
        result,
        "level_three_department_data",
        new String[][] {
          new String[] {"id", "varchar(48)", " not null", "ID", "", ""},
          new String[] {"belongs_to", "varchar(48)", "", "属于", "level_two_department_data", "id"},
          new String[] {"name", "varchar(52)", "", "名称", "", ""},
          new String[] {"description", "varchar(72)", "", "描述", "", ""},
          new String[] {"founded", "date", "", "成立", "", ""},
          new String[] {"version", "int", "", "版本", "", ""}
        },
        "三级部门",
        new String[] {
          "create unique index idx4id_ver_of_level_three_department on level_three_department_data (id, version);",
          "create  index idx4founded_of_level_three_department on level_three_department_data (founded);",
          "create  index idx4version_of_level_three_department on level_three_department_data (version);"
        },
        new String[] {
          "alter table level_three_department_data add constraint pk4id_of_level_three_department_data primary key (id);",
          "alter table level_three_department_data add constraint fk4belongs_to_of_level_three_department_data foreign key (belongs_to) references level_two_department_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
          ""
        });
  }
}
