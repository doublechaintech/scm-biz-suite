package com.doublechaintech.retailscm.employeequalifier;

import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class EmployeeQualifierTable {

  public static AccessKey withId(Object value) {
    AccessKey accessKey = new AccessKey();
    accessKey.setColumnName(COLUMN_ID);
    accessKey.setValue(value);
    return accessKey;
  }
  // Add extra identifiers

  // only this package can use this, so the scope is default, not public, not private either nor
  // protected
  public static final String TABLE_NAME = "employee_qualifier_data";
  static final String COLUMN_ID = "id";
  static final String COLUMN_EMPLOYEE = "employee";
  static final String COLUMN_QUALIFIED_TIME = "qualified_time";
  static final String COLUMN_TYPE = "type";
  static final String COLUMN_LEVEL = "level";
  static final String COLUMN_REMARK = "remark";
  static final String COLUMN_VERSION = "version";

  public static final String[] ALL_CLOUMNS = {
    COLUMN_ID,
    COLUMN_EMPLOYEE,
    COLUMN_QUALIFIED_TIME,
    COLUMN_TYPE,
    COLUMN_LEVEL,
    COLUMN_REMARK,
    COLUMN_VERSION
  };
  public static final String[] NORMAL_CLOUMNS = {
    COLUMN_EMPLOYEE, COLUMN_QUALIFIED_TIME, COLUMN_TYPE, COLUMN_LEVEL, COLUMN_REMARK
  };

  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result)
      throws Exception {
    RetailscmBaseUtils.ensureTable(
        userContext,
        result,
        "employee_qualifier_data",
        new String[][] {
          new String[] {"id", "varchar(48)", " not null", "ID", "", ""},
          new String[] {"employee", "varchar(48)", "", "员工", "employee_data", "id"},
          new String[] {"qualified_time", "date", "", "合格的时间", "", ""},
          new String[] {"type", "varchar(20)", "", "类型", "", ""},
          new String[] {"level", "varchar(8)", "", "水平", "", ""},
          new String[] {"remark", "varchar(36)", "", "备注", "", ""},
          new String[] {"version", "int", "", "版本", "", ""}
        },
        "员工资质",
        new String[] {
          "create unique index idx4id_ver_of_employee_qualifier on employee_qualifier_data (id, version);",
          "create  index idx4qualified_time_of_employee_qualifier on employee_qualifier_data (qualified_time);",
          "create  index idx4version_of_employee_qualifier on employee_qualifier_data (version);"
        },
        new String[] {
          "alter table employee_qualifier_data add constraint pk4id_of_employee_qualifier_data primary key (id);",
          "alter table employee_qualifier_data add constraint fk4employee_of_employee_qualifier_data foreign key (employee) references employee_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
          ""
        });
  }
}
