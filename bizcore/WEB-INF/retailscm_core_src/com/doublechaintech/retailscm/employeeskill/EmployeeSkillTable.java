package com.doublechaintech.retailscm.employeeskill;

import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class EmployeeSkillTable {

  public static AccessKey withId(Object value) {
    AccessKey accessKey = new AccessKey();
    accessKey.setColumnName(COLUMN_ID);
    accessKey.setValue(value);
    return accessKey;
  }
  // Add extra identifiers

  // only this package can use this, so the scope is default, not public, not private either nor
  // protected
  public static final String TABLE_NAME = "employee_skill_data";
  static final String COLUMN_ID = "id";
  static final String COLUMN_EMPLOYEE = "employee";
  static final String COLUMN_SKILL_TYPE = "skill_type";
  static final String COLUMN_DESCRIPTION = "description";
  static final String COLUMN_VERSION = "version";

  public static final String[] ALL_CLOUMNS = {
    COLUMN_ID, COLUMN_EMPLOYEE, COLUMN_SKILL_TYPE, COLUMN_DESCRIPTION, COLUMN_VERSION
  };
  public static final String[] NORMAL_CLOUMNS = {
    COLUMN_EMPLOYEE, COLUMN_SKILL_TYPE, COLUMN_DESCRIPTION
  };

  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result)
      throws Exception {
    RetailscmBaseUtils.ensureTable(
        userContext,
        result,
        "employee_skill_data",
        new String[][] {
          new String[] {"id", "varchar(48)", " not null", "ID", "", ""},
          new String[] {"employee", "varchar(48)", "", "员工", "employee_data", "id"},
          new String[] {"skill_type", "varchar(48)", "", "技能类型", "skill_type_data", "id"},
          new String[] {"description", "varchar(28)", "", "描述", "", ""},
          new String[] {"version", "int", "", "版本", "", ""}
        },
        "员工技能",
        new String[] {
          "create unique index idx4id_ver_of_employee_skill on employee_skill_data (id, version);",
          "create  index idx4version_of_employee_skill on employee_skill_data (version);"
        },
        new String[] {
          "alter table employee_skill_data add constraint pk4id_of_employee_skill_data primary key (id);",
          "alter table employee_skill_data add constraint fk4employee_of_employee_skill_data foreign key (employee) references employee_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
          "alter table employee_skill_data add constraint fk4skill_type_of_employee_skill_data foreign key (skill_type) references skill_type_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
          ""
        });
  }
}
